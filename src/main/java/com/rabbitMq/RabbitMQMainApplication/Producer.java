package com.rabbitMq.RabbitMQMainApplication;

import com.rabbitMq.RabbitMQMainApplication.config.MessageConfig;
import com.rabbitMq.RabbitMQMainApplication.dto.Order;
import com.rabbitMq.RabbitMQMainApplication.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class Producer {

   @Autowired
   private RabbitTemplate template;

   @PostMapping("/{restaurantName}")
   public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
      order.setOrderId(UUID.randomUUID().toString());
      OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed successfully in " + restaurantName);
      template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, orderStatus);
      return "Success !!";
   }
}