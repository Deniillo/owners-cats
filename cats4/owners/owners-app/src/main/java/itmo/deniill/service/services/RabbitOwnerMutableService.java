package itmo.deniill.service.services;

import itmo.deniill.OwnerDto;
import itmo.deniill.dao.entities.Owner;
import itmo.deniill.dao.repositories.OwnerRepository;
import itmo.deniill.models.QueueType;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableRabbit
@Transactional(readOnly = true)
public class RabbitOwnerMutableService implements OwnerMutableService {

    private final OwnerRepository ownerRepository;
    @Autowired
    public RabbitOwnerMutableService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    @Transactional
    @RabbitListener(queues = QueueType.OWNER_CREATE)
    public void createOwner(OwnerDto ownerDto) {
        Owner owner = new Owner(ownerDto.getName(), ownerDto.getBirthday());
        ownerRepository.save(owner);
    }

    @Override
    @Transactional
    @RabbitListener(queues = QueueType.DELETE_OWNER)
    public void deleteOwnerById(int ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}
