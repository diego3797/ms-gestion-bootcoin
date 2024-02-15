package com.prueba.mscomprabootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;


/**
 * .
 * Company
 */
@SuppressWarnings("unchecked")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

  private static final long serialVersionUID = 1L;

  @Valid
  private List<@Valid DataPersonal> titular;

  @Valid
  private List<@Valid DataPersonal> autorizedSignatory;


}

