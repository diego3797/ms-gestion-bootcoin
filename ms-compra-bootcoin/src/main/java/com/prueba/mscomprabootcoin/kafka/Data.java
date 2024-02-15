package com.prueba.mscomprabootcoin.kafka;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.prueba.mscomprabootcoin.util.EnumPayMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * .
 * Data
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Data {
    private BigDecimal amount;
    private String payMode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String accountNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cellphone;
}
