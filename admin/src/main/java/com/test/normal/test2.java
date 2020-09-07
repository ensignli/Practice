package com.test.normal;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;

public class test2 {

	public static void main(String[] args) {
	      String s= String.format("%s%s/clientPrivate.key","","345454");
	      //System.out.println(s);
	      
	    /*  List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
	      String citiesCommaSeparated = String.join(",", list);
	      System.out.println(citiesCommaSeparated);*/
	      
	         List<List<Integer>> list = new ArrayList<>();
	        list.add(Arrays.asList(new Integer[]{1,2}));
	        list.add(Arrays.asList(new Integer[]{3,4}));
	        list.add(null);
	        list.add(Arrays.asList(new Integer[]{4,3,5}));
	        List<Integer> result = list.stream()
	                .filter(item-> item != null)
	                .reduce(new ArrayList<>(), (all, item ) -> {all.addAll(item); return all;});
	        
	        result.add(0,9);
	        System.out.println(result);
	        
	        IdentityHashMap<String, String> myMultimap = new IdentityHashMap<String, String>();
	        
	        myMultimap.put("Fruits", "Bannana");
			myMultimap.put("Fruits", "Apple");
			myMultimap.put("Fruits", "Pear");
			myMultimap.put("Fruits", "Pear");
			myMultimap.put("Vegetables", "Carrot");
			
			myMultimap.forEach((k, v) -> {
				System.out.println("key:"+k+",value:"+v);
	    	});
			
			Boolean a=false;
			Boolean c=false;
			System.out.print(a.equals(c)+"#"+(a==c));
			
			String payAmount="5678.00";
			   BigDecimal decimal = (new BigDecimal(payAmount.toString().substring(0, payAmount.toString().indexOf(".")))).setScale(2);
			   System.out.print(decimal.setScale(-2, RoundingMode.CEILING).setScale(3));
	            BigDecimal setScale = decimal.setScale(-2, RoundingMode.CEILING).setScale(2);
	            System.out.print(setScale);
	            
	            
	            String msg;
	            if(a) {
	            	msg="1";
	            }else {
	            	msg="2";
	            }
	            System.out.print("is true=:"+StringUtils.isNotEmpty(msg));
	            
	            String msgq;
				try {
					msgq = URLEncoder.encode("(9999999300) 支付金额小于该商户最小支付金额", "utf-8");
					  System.out.println(msgq);
			            System.out.println(URLDecoder.decode(msgq, "utf-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          
	}

}
