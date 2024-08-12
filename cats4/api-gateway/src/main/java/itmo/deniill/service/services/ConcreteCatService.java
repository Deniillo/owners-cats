package itmo.deniill.service.services;

import itmo.deniill.CatClient;
import itmo.deniill.CatDto;
import itmo.deniill.models.CatIdContext;
import itmo.deniill.models.FriendshipContext;
import itmo.deniill.models.CreateCatContext;
import itmo.deniill.models.QueueType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcreteCatService implements CatService {

    private final CatClient catClient;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    ConcreteCatService(CatClient catClient, RabbitTemplate rabbitTemplate) {
        this.catClient = catClient;
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public void createCat(CatDto catDto, Integer ownerId) {
        rabbitTemplate.convertAndSend(QueueType.CAT_CREATE, new CreateCatContext(catDto, ownerId));
    }
    @Override
    public void friendship(int catId1, int catId2, Integer ownerId) {
        rabbitTemplate.convertAndSend(QueueType.ADD_FRIEND, new FriendshipContext(catId1, catId2, ownerId));
    }

    @Override
    public void unFriendship(int catId1, int catId2, Integer ownerId) {
        rabbitTemplate.convertAndSend(QueueType.DELETE_FRIEND, new FriendshipContext(catId1, catId2, ownerId));
    }

    @Override
    public void deleteCatById(int catId, Integer ownerId) {
        rabbitTemplate.convertAndSend(QueueType.DELETE_CAT, new CatIdContext(catId, ownerId));
    }

    @Override
    public List<CatDto> getCatsByCriteria(String id, String name, String breed, String colour, String ownerId) {
        return catClient.getCatsByCriteria(id, name, breed, colour, ownerId);
    }
}
