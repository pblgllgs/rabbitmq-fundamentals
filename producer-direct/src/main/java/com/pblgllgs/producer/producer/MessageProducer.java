package com.pblgllgs.producer.producer;
/*
 *
 * @author pblgl
 * Created on 18-11-2023
 *
 */

import com.pblgllgs.producer.entities.Message;
import com.pblgllgs.producer.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final MessageService messageService;

    @Value("${broker.routing-key-uno}")
    private String routingKey;

    @Value("${broker.exchange-direct-uno}")
    private String exchangeDirect;

    public void sendMessage(Message msg) {
        Message message = Message.builder()
                .msg(msg.getMsg())
                .routingKey(routingKey)
                .build();
        Message savedMessage = messageService.saveMessage(message);
        rabbitTemplate.convertAndSend(exchangeDirect, routingKey, savedMessage);
        log.info("Mensaje enviado con clave de enrutamiento '" + routingKey + message);
    }
}
