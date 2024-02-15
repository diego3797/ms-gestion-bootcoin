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
 * Account
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Debit {

  private static final long serialVersionUID = 1L;

  private String numberCard;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private List<@Valid AccountAssociate> associatedAccount;

  @Valid
  private List<@Valid Movements> movements = new ArrayList<>();

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String dateCreation;

  private Sucursal sucursal;

  private BigDecimal balance;

}

