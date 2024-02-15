package com.prueba.mscomprabootcoin.service;

import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * .
 * <b>Class</b>: BuyService <br/>
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
public interface BuyService {

    Mono<Void> registerBuy(String msg) throws IOException;
}
