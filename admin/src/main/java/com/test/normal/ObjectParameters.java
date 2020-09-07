package com.test.normal;

import com.test.vo.Student;

import java.util.Date;


public class ObjectParameters {

	public static void main(String[] args) {
		Student stu=new Student();
		stu.setNameCN("张三");
		setStudent(stu);
		System.out.println(stu.toString());
	}
	
	private static String setStudent(Student stu) {
		stu.setAge(11);
		stu.setId("1");
		stu.setCreatetime(new Date());
		return "";
	}

}
