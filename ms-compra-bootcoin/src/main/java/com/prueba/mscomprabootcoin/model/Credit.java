package com.prueba.mscomprabootcoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * .
 * Credit
 */
@SuppressWarnings("unchecked")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Credit {

  private static final long serialVersionUID = 1L;

  private String type;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String card;

  private String number;

  private BigDecimal limitCredit;

  @Valid
  private List<@Valid Movements> movements = new ArrayList<>();

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private Company company;

  private String dateCreation;

  private Sucursal sucursal;

  private BigDecimal balance;


}

