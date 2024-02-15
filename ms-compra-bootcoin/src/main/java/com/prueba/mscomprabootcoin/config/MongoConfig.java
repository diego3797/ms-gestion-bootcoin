package com.prueba.mscomprabootcoin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * .
 * <b>Class</b>: MongoConfig <br/>
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
@Configuration
public class MongoConfig {
    @Autowired
    private ReactiveMongoDatabaseFactory factory;

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoMappingContext mongoMappingContext) {
        MappingMongoConverter converter = new MappingMongoConverter(NoOpDbRefResolver.INSTANCE, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }



}
