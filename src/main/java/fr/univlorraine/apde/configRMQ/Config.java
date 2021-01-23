package fr.univlorraine.apde.configRMQ;

import fr.univlorraine.apde.controller.DeliveryController;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    @Bean
    public Queue queue() {
        return new Queue("delivery");
    }

    @Profile("sender")
    @Bean
    public DeliveryController sender() {
        return new DeliveryController();
    }
}
