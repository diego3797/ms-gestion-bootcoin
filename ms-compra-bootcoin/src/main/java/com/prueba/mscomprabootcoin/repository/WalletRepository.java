package com.prueba.mscomprabootcoin.repository;


import com.prueba.mscomprabootcoin.model.Wallet;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * .
 * <b>Class</b>: WalletRepository <br/>
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
public interface WalletRepository extends ReactiveMongoRepository<Wallet, Object> {

    @Query(value = "{ 'cellphone': ?0 }")
    Mono<Wallet> findWalletByCellphone(String cellphone);

}
