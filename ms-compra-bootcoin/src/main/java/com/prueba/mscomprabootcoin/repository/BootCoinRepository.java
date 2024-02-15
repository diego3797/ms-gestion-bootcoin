package com.prueba.mscomprabootcoin.repository;

import com.prueba.mscomprabootcoin.model.BootCoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


/**
 * .
 * <b>Class</b>: BootCoinRepository <br/>
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
@Repository
public interface BootCoinRepository extends ReactiveMongoRepository<BootCoin, Object> {

}
