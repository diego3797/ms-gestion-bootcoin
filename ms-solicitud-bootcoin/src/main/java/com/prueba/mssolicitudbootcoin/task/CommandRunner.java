package com.prueba.mssolicitudbootcoin.task;

import com.prueba.mssolicitudbootcoin.service.QuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {

    private final QuoteService txService;

    public CommandRunner(QuoteService txService) {
        this.txService = txService;
    }

    @Override
    public void run(String... args) throws Exception {
        txService.sendQuote();
    }
}
