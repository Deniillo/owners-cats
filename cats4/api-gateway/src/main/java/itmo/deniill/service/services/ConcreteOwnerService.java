package itmo.deniill.service.services;

import itmo.deniill.OwnerClient;
import itmo.deniill.OwnerDto;
import itmo.deniill.models.QueueType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcreteOwnerService implements OwnerService{

    private final RabbitTemplate rabbitTemplate;
    private final OwnerClient ownerClient;

    @Autowired
    public ConcreteOwnerService(RabbitTemplate rabbitTemplate, OwnerClient ownerClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.ownerClient = ownerClient;
    }


    @Override
    public void createOwner(OwnerDto ownerDto) {
        rabbitTemplate.convertAndSend(QueueType.OWNER_CREATE, ownerDto);
    }

    @Override
    public OwnerDto getOwnerById(int ownerId) {
        return ownerClient.getOwnerById(ownerId);
    }

    @Override
    public List<OwnerDto> getOwners() {
        return ownerClient.getAllOwners();
    }

    @Override
    public void deleteOwnerById(int ownerId) {
        rabbitTemplate.convertAndSend(QueueType.DELETE_OWNER, ownerId);
    }
}
