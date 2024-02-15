package com.prueba.mscomprabootcoin.service.impl;

import com.prueba.mscomprabootcoin.kafka.Data;
import com.prueba.mscomprabootcoin.kafka.KafkaConsumer;
import com.prueba.mscomprabootcoin.kafka.KafkaMessage;
import com.prueba.mscomprabootcoin.model.BootCoin;
import com.prueba.mscomprabootcoin.repository.BootCoinRepository;
import com.prueba.mscomprabootcoin.repository.ClientRepository;
import com.prueba.mscomprabootcoin.repository.WalletRepository;
import com.prueba.mscomprabootcoin.service.BuyService;
import com.prueba.mscomprabootcoin.util.EnumPayMode;
import com.prueba.mscomprabootcoin.util.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * a.
 * <b>Class</b>: BuyServiceImpl <br/>
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
public class BuyServiceImpl implements BuyService {
    @Autowired
    private ClientRepository cliRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private BootCoinRepository bootCoinRepository;

    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Override
    public Mono<Void> registerBuy(String msg) throws IOException {
        KafkaMessage<Data> dataMsg = Utils.readKafkaMessageFromString(msg, Data.class);
        Data data = dataMsg.getData();

        String numberDocument = "";
        String email = "";
        BootCoin bootCoin = null;

        //Valida datos de socicitud
        if (BuyValidation.checkQuoteAmount(data)) {
            logger.info("El monto de la solicitud es incorrecta o nula");
            return Mono.empty();
        }

        if (data.getPayMode().equals(EnumPayMode.TRANSFERENCIA.toString())
                && cliRepository.findAccountByNumber(data.getAccountNumber()).block() == null) {
            logger.info("El numero de cuenta no existe");
            return Mono.empty();
        }

        if (data.getPayMode().equals(EnumPayMode.YANKI.toString())
                && walletRepository.findWalletByCellphone(data.getCellphone()).block() == null) {
            logger.info("El numero de telefono no existe en YANKI");
            return Mono.empty();
        }

        if (data.getPayMode().equals(EnumPayMode.TRANSFERENCIA.toString())) {
            numberDocument = cliRepository.findAccountByNumber(data.getAccountNumber()).block()
                                .getDataPersonal().getDocumentNumber();

            email = cliRepository.findAccountByNumber(data.getAccountNumber()).block()
                                .getEmail();

            bootCoin = BootCoin.builder()
                            .transactionNumber(String.valueOf(Utils.generateNumberTransaction()))
                            .documentNumber(numberDocument)
                            .accountNumber(data.getAccountNumber())
                            .email(email)
                            .amount(data.getAmount())
                            .payMode(data.getPayMode())
                            .build();
        }

        if (data.getPayMode().equals(EnumPayMode.YANKI.toString())){
            numberDocument = walletRepository.findWalletByCellphone(data.getCellphone()).block()
                                .getDocumentNumber();

            email = walletRepository.findWalletByCellphone(data.getCellphone()).block()
                                .getEmail();

            bootCoin = BootCoin.builder()
                            .transactionNumber(String.valueOf(Utils.generateNumberTransaction()))
                            .documentNumber(numberDocument)
                            .cellphone(data.getCellphone())
                            .email(email)
                            .amount(data.getAmount())
                            .payMode(data.getPayMode())
                            .build();
        }

        bootCoinRepository.save(bootCoin).subscribe();

        return Mono.empty();
    }
}
