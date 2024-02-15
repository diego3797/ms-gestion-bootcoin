package com.prueba.mscomprabootcoin.model;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * .
 * Movements
 */
@SuppressWarnings("unchecked")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovementsWallet {
    private static final long serialVersionUID = 1L;

    private String numberOperation;

    private String cellphoneEmisor;

    private String cellphoneReceiver;

    private Date dateOperation;

    private BigDecimal amount;
}
