package com.pblgllgs.consumer.config;
/*
 *
 * @author pblgl
 * Created on 18-11-2023
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQConfig {

    @Value("${broker.queue-direct-uno}")
    private String queue;

    @Bean
    public Queue miQueueDirectUno() {
        return new Queue(queue);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
