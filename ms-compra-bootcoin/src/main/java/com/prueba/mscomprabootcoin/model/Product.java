package com.prueba.mscomprabootcoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;


/**
 * .
 * Product
 */
@SuppressWarnings("unchecked")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

  private static final long serialVersionUID = 1L;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private List<@Valid Account> account;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private List<@Valid Credit> credit;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Valid
  private List<@Valid Debit> debit;

}

