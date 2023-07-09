package org.example.dto;

import java.math.BigDecimal;

public enum Coin {

  TWO_POUND_COIN(BigDecimal.valueOf( (double) 200 )),
  ONE_POUND_COIN(BigDecimal.valueOf( (double) 100 )),
  FIFTY_PENCE_COIN(BigDecimal.valueOf( (double) 50 )),
  TWENTY_PENCE_COIN(BigDecimal.valueOf( (double) 20 )),
  TEN_PENCE_COIN(BigDecimal.valueOf( (double) 10 )),
  FIVE_PENCE_COIN(BigDecimal.valueOf( (double) 5 )),
  TWO_PENCE_COIN(BigDecimal.valueOf( (double) 2 )),
  ONE_PENCE_COIN(BigDecimal.valueOf( (double) 1 ));

  private BigDecimal num = BigDecimal.ZERO;

 Coin(BigDecimal num) {
   this.num = num;
 }

  public BigDecimal getValue() {
   return num;
  }
}
