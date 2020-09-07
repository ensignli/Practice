package com.test.vo;

import lombok.Data;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class Student {
	private String id;
	private String nameCN;
	private String nameEN;
	private String nameVI;
	private Integer age;
	private Date createtime;
	public static void main(String[] args) throws Exception {
		List<Student> stuList=new ArrayList<Student>();
       for (int i = 0; i < 1000; i++) {
    	  Student person = new Student();
  		  person.setId(i+"");
  		  person.setNameCN("ÕÅÈý"+i);
  		  person.setNameEN("zhangsan"+i);
  		  person.setNameVI("zhangsan"+i);
  		  stuList.add(person);
	  }
       LinkedHashMap<String, String> childList = new LinkedHashMap<String, String>();

       for (Student stu : stuList) {
           childList.put(stu.getId(), setLangValue(stu,"name","en_US"));
       }
	
       System.out.println(childList.toString());
	    
	}
	
	public static String setLangValue(Object model, String key, String lang) {
        Class clazz = model.getClass();
        Object value="";
        try {
        	 if ("en_US".equals(lang)) {
        		 key =key +"CN";
             } else if ("vi_VN".equals(lang)) {
            	 key =key +"VI";
             } else {
            	 key =key +"CN";
             }
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            value = method.invoke(model);   
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return value.toString();
    }

}
