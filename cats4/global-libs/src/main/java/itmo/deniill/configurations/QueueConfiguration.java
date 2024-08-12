package itmo.deniill.configurations;

import itmo.deniill.models.QueueType;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {
    @Bean
    public Queue ownerCreate() {
        return new Queue(QueueType.OWNER_CREATE);
    }

    @Bean
    public Queue catCreate() {
        return new Queue(QueueType.CAT_CREATE);
    }

    @Bean
    public Queue addFriend() {
        return new Queue(QueueType.ADD_FRIEND);
    }

    @Bean
    public Queue deleteFriend() {
        return new Queue(QueueType.DELETE_FRIEND);
    }

    @Bean
    public Queue deleteCat() {
        return new Queue(QueueType.DELETE_CAT);
    }

    @Bean
    public Queue deleteOwner() {
        return new Queue(QueueType.DELETE_OWNER);
    }
}
