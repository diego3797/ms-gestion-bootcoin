package com.prueba.mssolicitudbootcoin.service;

import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * .
 * <b>Class</b>: QuoteService <br/>
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
public interface QuoteService {

    Mono<Void> sendQuote() throws IOException;
}
