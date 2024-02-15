package com.prueba.mscomprabootcoin.repository;


import com.prueba.mscomprabootcoin.model.Client;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * .
 * <b>Class</b>: ClientRepository <br/>
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
public interface ClientRepository extends ReactiveMongoRepository<Client, Object> {
    @Query(value = "{ 'product.account.number': ?0 }", fields = "{  clientType: 1,"
                                                            + " profileType: 1,"
                                                            + " dataPersonal: 1,"
                                                            + " dataCompany: 1,"
                                                            + " email: 1,"
                                                            + "'product.account.$': 1 }")
    Mono<Client> findAccountByNumber(String number);
}
