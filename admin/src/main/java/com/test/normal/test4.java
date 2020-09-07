package com.test.normal;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class test4 {

	public static void main(String[] args) {
		String str="lizhan,dd";
		System.out.println(Arrays.asList(str.split(",")));
		
		
		
		
		int bidTmp=0;
		
		for(int i=0;i<3;i++){
			bidTmp=i;
			System.out.println(bidTmp+1);
			
			
			
			System.out.println(bidTmp);
			
		}
		
		
		String paycode ="";
		System.out.println(paycode.indexOf("4"));
		//System.out.println(paycode.substring(paycode.indexOf("")+1, paycode.length()));
		
		
		String str2 = "ab=1";
        Map<String, String> collect = Arrays.stream(str2.split("&"))
                .map(s -> s.split("="))
                .collect(Collectors.toMap(x -> x[0], x -> x[1],
                        (u, v) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", u));
                        },LinkedHashMap::new));



        System.out.println(collect);
        System.out.println(new BigDecimal("100.000").setScale(2, RoundingMode.HALF_UP).toString());
		
        System.out.println("https://admindemo.cfdealer88.com/".indexOf("1demo"));

		System.out.println("81000332".substring(0,3));

		System.out.println(StringUtils.deleteWhitespace("  81 0 0 033 2 "));
	}

}
