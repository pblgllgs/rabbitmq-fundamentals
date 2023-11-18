package com.pblgllgs.consumer.consumer;
/*
 *
 * @author pblgl
 * Created on 18-11-2023
 *
 */

import com.pblgllgs.consumer.entities.Message;
import com.pblgllgs.consumer.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MessageConsumer {
    private final MessageService messageService;

    @Value("${broker.queue-direct-uno}")
    private String queue;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @RabbitListener(queues = "${broker.queue-direct-uno}")
    public void listenerEmailQueue(@Payload Message message) {
        messageService.saveMessage(message);
        log.info(message.getMsg());
    }
}
