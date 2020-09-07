package com.test.normal;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

public class OptionalPractice {

	public static void main(String[] args) {
		String str="phone[]";
		String newStr= Optional.ofNullable(str).orElse("");
		//System.out.print(newStr);

		 boolean status = "chec[]kbox".contains("[]");  
		 //System.out.print(status);
		 
		    String[]  array=new String[] {};
            //System.out.print(ArrayUtils.isNotEmpty(array));
		    
		    HashMap<String, Object> requestEntity = new LinkedHashMap<>(1);
            String[] phone = new String[]{"18275401234"};
            //requestEntity.put("phone[]", phone);
            
            requestEntity.put("name","lizhan");
            requestEntity.put("class","3°æ");
            requestEntity.put("age",12);
            requestEntity.put("phone","15243055454");
            for (String key : requestEntity.keySet()) {
            	  System.out.println(key+requestEntity.get(key));
            }
            
            HashMap<String, String> resultMap = new LinkedHashMap<>(1);
            resultMap.put("333","333");
            System.out.println(Optional.ofNullable(resultMap).map(u -> u.toString()).orElse(""));
            
   
            //System.out.println(str.substring(0,str.indexOf("[")));
            
          
	}
	

}
