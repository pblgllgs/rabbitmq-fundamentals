package com.pblgllgs.producer.config;
/*
 *
 * @author pblgl
 * Created on 18-11-2023
 *
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.TopicExchangeParser;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    @Value("${broker.routing-key-dos}")
    private String routingKey;

    @Value("${broker.exchange-topic-uno}")
    private String exchangeTopic;

    @Value("${broker.queue-direct-uno}")
    private String queueDirectUno;

    @Bean
    public TopicExchange exchangeUno() {
        return new TopicExchange(exchangeTopic);
    }

    @Bean
    public Queue miQueueDirectUno() {
        return new Queue(queueDirectUno);
    }

    @Bean
    public Binding bindingDirect(Queue miQueueDirectUno, TopicExchange exchangeUno) {
        return BindingBuilder.bind(miQueueDirectUno).to(exchangeUno).with(routingKey);
    }

    @Bean
    public RabbitTemplate rabbitTemplateDirect(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(exchangeTopic);
        rabbitTemplate.setRoutingKey(routingKey);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
