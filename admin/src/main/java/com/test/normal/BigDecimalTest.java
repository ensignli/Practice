package com.test.normal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

	public static void main(String[] args) {
		  BigDecimal transAmount = new BigDecimal("123");
    	  BigDecimal gatewayAmount = transAmount.multiply(new BigDecimal("6.0001"));
		  BigDecimal divisor = new BigDecimal(10);
		  BigDecimal tmp =gatewayAmount.divide(divisor,0, RoundingMode.UP);
		  BigDecimal gatewayAmountChanged = tmp.multiply(divisor);
		  System.out.println(gatewayAmountChanged);

		  BigDecimal amountChanged = gatewayAmountChanged.divide(new BigDecimal("6.5332"), 2, RoundingMode.HALF_UP);
		  System.out.println(amountChanged);
		  
		  
		  System.out.println(gatewayAmount.setScale(2, RoundingMode.HALF_UP));


		  BigDecimal gatewayAmount2 = new BigDecimal("1346.334");
		  System.out.println(gatewayAmount2);
          //处理转换后的金额1346.66换成1347.00
          BigDecimal divide = gatewayAmount2.setScale(2, RoundingMode.HALF_UP);
    	  System.out.println("divede=="+divide);

		System.out.println(new BigDecimal("23355000").multiply(BigDecimal.ONE.divide(new BigDecimal("23355"), 10, RoundingMode.UP)).stripTrailingZeros().toPlainString());
    	 
	}

}
