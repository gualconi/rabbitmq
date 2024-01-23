package br.com.felipe.producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.felipe.producer.configs.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static br.com.felipe.producer.configs.RabbitMQConfig.RK_PRODUCT_LOG;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message){
        log.info("Received Message " + message);
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }
}
