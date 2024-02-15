package com.prueba.mscomprabootcoin.service.impl;

import com.prueba.mscomprabootcoin.kafka.Data;

import java.math.BigDecimal;

public class BuyValidation {
    public static boolean checkQuoteAmount(Data data) {
        return (data.getAmount() == null) || (data.getAmount().compareTo(BigDecimal.ZERO) == 0);
    }
}
