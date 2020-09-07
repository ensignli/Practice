package com.test.normal;

import com.test.vo.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Operation {

	public static void getData() {
		List<Student> stuList = new ArrayList<Student>();
		for (int i = 0; i < 10; i++) {
			Student person = new Student();
			person.setId(i + "");
			person.setNameCN("张三" + i);
			person.setNameEN("zhangsan" + i);
			person.setNameVI("zhangsan" + i);
			stuList.add(person);
		}

		List<String> students = stuList.stream().map(new Function<Student, String>() {
			@Override
			public String apply(Student t) {
				return t.getNameCN();
			}
		}).collect(Collectors.toList());

		System.out.print(students.toString());
	}

	private static <T> T execute(Student su, Function<T, T> callback) {
		su.setAge(1);
		su.setId("22");
		su.setNameCN("gg");
		return callback.apply((T)su);
	}

	public static void main(String[] args) {
		getData();
		Student t=new Student();
		t.setCreatetime(new Date());
		Student tt= execute(t, (Student) -> {
			return t;
		});
		System.out.print(tt.toString());
		
		
	    Consumer<String> consumer= p -> System.out.println(p);    // 因为没有出参，常用于打印、发送短信等消费动作
		consumer.accept("18800008888");
		
	        //套利客
	      // String checkStaus=checkArbitrageur(tracker);
	      int  updateSign= execute1(t, (x) -> {
	        	System.out.println(x);
	        	if(x>0) {
	        		return 5;
	        	}
	        	return x;
	        });
	      
	      System.out.println("updateSign:"+updateSign);
	}
	
	
	 public static int execute1(Student t, Function<Integer, Integer> callback) {
	        if ("1".equals("5")) {
	            return callback.apply(1);
	        }
	        //优惠风控风险客户
	        if ("2".equals("2")) {
	        	t.setAge(44);
	    		t.setId("555");
	    		t.setNameCN("6");
	            return callback.apply(2);
	        }
	        return callback.apply(0);
	    }

}
