package com.test.normal;

import com.test.vo.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class testInvoke {

	public static void main(String[] args) {
		Student model = new Student();
		Field[] field = model.getClass().getDeclaredFields(); // ��ȡʵ������������ԣ�����Field����
        try {
            for (int j = 0; j < field.length; j++) { // ������������
                String name = field[j].getName(); // ��ȡ���Ե�����
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // �����Ե����ַ���д�����㹹��get��set����
                String type = field[j].getGenericType().toString(); // ��ȡ���Ե�����
                if (type.equals("class java.lang.String")) { // ���type�������ͣ���ǰ�����"class "�����������
                    Method m = model.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(model); // ����getter������ȡ����ֵ
                    if (value == null) {
                        m = model.getClass().getMethod("set"+name, String.class);
                        m.invoke(model, "");
                    }
                }
                if (type.equals("class java.lang.Integer")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Integer value = (Integer) m.invoke(model);
                    if (value == null) {
                        m = model.getClass().getMethod("set"+name, Integer.class);
                        m.invoke(model,1);
                    }
                }
                if (type.equals("class java.lang.Boolean")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Boolean value = (Boolean) m.invoke(model);
                    if (value == null) {
                        m = model.getClass().getMethod("set"+name, Boolean.class);
                        m.invoke(model, false);
                    }
                }
                if (type.equals("class java.util.Date")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Date value = (Date) m.invoke(model);
                    if (value == null) {
                        m = model.getClass().getMethod("set"+name, Date.class);
                        m.invoke(model, new Date());
                    }
                }
             // �������Ҫ,���Է������������������,�����Ӷ��������͵��ж�
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        
        
        System.out.println(model);
	}
	
	

}
