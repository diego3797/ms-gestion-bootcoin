package com.prueba.mscomprabootcoin.kafka;

import com.prueba.mscomprabootcoin.service.BuyService;
import com.prueba.mscomprabootcoin.util.Constante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import java.io.IOException;

/**
 * .
 * <b>Class</b>: KafkaConsumer <br/>
 *
 * <u>Service Provider</u>: PruebaTest <br/>
 * <u>Developed by</u>: Diego Condezo <br/>
 * <u>Changes:</u><br/>
 * <ul>
 *   <li>
 *     Febrero 08, 2024 Creación de Clase.
 *   </li>
 * </ul>
 */
@Configuration
public class KafkaConsumer {

    @Autowired
    BuyService buyService;
    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    /**
     * a.
     *
     */
    @KafkaListener(topics = {Constante.TOPIC_SOLICITUD_BOOTCOIN}, groupId = "my-group-id")
    public void consumerTransaction(String message) throws IOException {

        logger.info(String.format("Received message quote buy: %s", message));

        buyService.registerBuy(message);
    }


}