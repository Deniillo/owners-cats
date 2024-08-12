package itmo.deniill.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RabbitConfiguration.class,
        QueueConfiguration.class
})
public class MainSignalConfiguration {
}
