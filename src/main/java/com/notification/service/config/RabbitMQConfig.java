package com.notification.service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_CART = "cartQueue";
    public static final String EXCHANGE_CART = "cartExchange";
    public static final String ROUTING_KEY_CART = "cart.created";

    @Bean
    public Queue cartQueue() {
        return new Queue(QUEUE_CART);
    }

    @Bean
    public TopicExchange cartExchange() {
        return new TopicExchange(EXCHANGE_CART);
    }

    @Bean
    public Binding bindingCart(Queue cartQueue, TopicExchange cartExchange) {
        return BindingBuilder
                .bind(cartQueue)
                .to(cartExchange)
                .with(ROUTING_KEY_CART);
    }

    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
