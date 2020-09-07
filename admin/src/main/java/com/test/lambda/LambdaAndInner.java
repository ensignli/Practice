package com.test.lambda;

import com.test.vo.IPMessage;

public class LambdaAndInner {
	private int age = 12;
	private static String name = "软件中心";

	public void test() {
		String book = "effective java";
		IPMessage iPMessage = new IPMessage();
		Displayable dis = () -> {
			System.out.println("book的局部变量为" + book);
			age = age + 12;
			IPMessage iPMessage2 = new IPMessage();
			iPMessage2.setIpAddress("127.0.0.1");
			iPMessage2.setIpPort(8080);
			iPMessage2.setIpType("1");
			//iPMessage=iPMessage2;  报错不能赋值
			System.out.println("外部类的age的实例变量为" + age);
			System.out.println("外部类的name类变量为" + name);
		};
		System.out.println("age==" + age);
		dis.display();
		System.out.println(dis.add(3, 5));
		System.out.print(iPMessage.getIpAddress());

	}

	public static void main(String[] args) {
		LambdaAndInner lambda = new LambdaAndInner();
		lambda.test();

	}
}
