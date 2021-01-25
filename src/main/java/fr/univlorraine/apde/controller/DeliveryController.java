package fr.univlorraine.apde.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DylanLICHO
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DeliveryController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @PostMapping(value = "addDelivery")
    public void addDelivery(@RequestBody String s){
        this.template.convertAndSend(queue.getName(), s);
    }
}
