package com.prueba.mscomprabootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * .
 * Account
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountAssociate {

  private String accountNumber;

  private String dateAssociate;

}
