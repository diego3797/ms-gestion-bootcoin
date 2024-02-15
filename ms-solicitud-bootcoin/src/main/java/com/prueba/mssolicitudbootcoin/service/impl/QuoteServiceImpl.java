package com.prueba.mssolicitudbootcoin.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.mssolicitudbootcoin.service.QuoteService;
import com.prueba.mssolicitudbootcoin.util.Constante;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;

/**
 * a.
 * <b>Class</b>: QuoteServiceImpl <br/>
 *
 * <u>Service Provider</u>: PruebaTest <br/>
 * <u>Developed by</u>: Diego Condezo <br/>
 * <u>Changes:</u><br/>
 * <ul>
 *   <li>
 *     Febrero 14, 2024 Creación de Clase.
 *   </li>
 * </ul>
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public QuoteServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Mono<Void> sendQuote() throws IOException {
        JsonNode jsonNode = null;
        try {
            InputStream inputStream = QuoteServiceImpl.class.getResourceAsStream("/quoteBootCoin.json");
            ObjectMapper mapper = new ObjectMapper();
            jsonNode = mapper.readTree(inputStream);

            System.out.println(jsonNode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (jsonNode != null) kafkaTemplate.send(Constante.TOPIC_SOLICITUD_BOOTCOIN, jsonNode.toString());
        return null;
    }
}
