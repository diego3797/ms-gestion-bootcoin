package com.prueba.mscomprabootcoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;


/**
 * .
 * Account
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

  private static final long serialVersionUID = 1L;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String type;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String card;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String number;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private List<@Valid AccountAssociate> associatedAccount;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private BigDecimal dayMovement;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private BigDecimal comission;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private List<@Valid Movements> movements;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String dateCreation;

  private Sucursal sucursal;

  private BigDecimal balance;

}

