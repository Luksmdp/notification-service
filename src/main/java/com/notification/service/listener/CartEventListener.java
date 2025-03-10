package com.notification.service.listener;

import com.muebleselremanso.elremansov2.model.entity.Cart;
import com.notification.service.config.RabbitMQConfig;
import com.notification.service.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CartEventListener {

    private final EmailService emailService;

    public CartEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_CART)
    public void handleCartCreatedEvent(Cart cart) {
        System.out.println("Evento de carrito recibido: " + cart);
        // Enviar el correo a la dirección deseada
        emailService.sendSimpleMessage("luksmdp@gmail.com", "Nuevo carrito creado", "Detalles del carrito: " + cart);
    }
}
