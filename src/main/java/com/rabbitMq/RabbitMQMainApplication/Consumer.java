package com.rabbitMq.RabbitMQMainApplication;

import com.rabbitMq.RabbitMQMainApplication.config.MessageConfig;
import com.rabbitMq.RabbitMQMainApplication.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
   @RabbitListener(queues = MessageConfig.QUEUE)
   public void consumeMessageFromQueue(OrderStatus orderStatus) {
      System.out.println("Message received from queue : " + orderStatus);
   }
}