package itmo.deniill.service.services;

import itmo.deniill.dao.entities.Cat;
import itmo.deniill.dao.repositories.CatRepository;
import itmo.deniill.exceptions.ErrorException;
import itmo.deniill.models.CatIdContext;
import itmo.deniill.models.FriendshipContext;
import itmo.deniill.models.CreateCatContext;
import itmo.deniill.models.QueueType;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@EnableRabbit
@Transactional(readOnly = true)
public class RabbitCatMutableService implements CatMutableService {

    private final CatRepository catRepository;


    @Autowired
    public RabbitCatMutableService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    @Transactional
    @RabbitListener(queues = QueueType.CAT_CREATE)
    public void createCat(CreateCatContext message) {
        Integer currentOwnerId = message.getOwnerId();
        if(currentOwnerId == null){
            currentOwnerId = message.getCatDto().getOwnerId();
        }
        Cat cat = new Cat(
                message.getCatDto().getName(),
                message.getCatDto().getBirthday(),
                message.getCatDto().getBreed(),
                message.getCatDto().getColour(),
                currentOwnerId,
                new ArrayList<>()
        );
        catRepository.save(cat);
    }

    @Override
    @Transactional
    @RabbitListener(queues = QueueType.ADD_FRIEND)
    public void friendship(FriendshipContext message) {
        Cat cat1 = catRepository.findById(message.getCatId1()).orElseThrow();
        Cat cat2 = catRepository.findById(message.getCatId2()).orElseThrow();
        if(message.getOwnerId() != null && !cat1.getOwnerId().equals(message.getOwnerId())){
            throw new ErrorException("It is not your cat!");
        }
        cat1.addFriend(cat2);
        cat2.addFriend(cat1);
        catRepository.save(cat1);
    }

    @Override
    @Transactional
    @RabbitListener(queues = QueueType.DELETE_FRIEND)
    public void unFriendship(FriendshipContext message) {
        Cat cat1 = catRepository.findById(message.getCatId1()).orElseThrow();
        Cat cat2 = catRepository.findById(message.getCatId2()).orElseThrow();
        if(message.getOwnerId() != null && !cat1.getOwnerId().equals(message.getOwnerId())){
            throw new ErrorException("It is not your cat!");
        }
        cat1.deleteFriend(cat2);
        cat2.deleteFriend(cat1);
        catRepository.save(cat1);
    }

    @Override
    @Transactional
    @RabbitListener(queues = QueueType.DELETE_CAT)
    public void deleteCatById(CatIdContext message) {
        Cat currentCat = catRepository.findById(message.getCatId()).orElseThrow();
        if(message.getOwnerId() != null && !currentCat.getOwnerId().equals(message.getOwnerId())){
            throw new ErrorException("It is not your cat!");
        }
        for (Cat cat : currentCat.getFriends()) {
            cat.getFriends().remove(currentCat);
            catRepository.save(cat);
        }
        currentCat.getFriends().clear();
        catRepository.delete(currentCat);
    }
}
