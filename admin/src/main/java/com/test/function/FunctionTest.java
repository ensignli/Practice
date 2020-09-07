package com.test.function;

import com.test.vo.ActiveUserVo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/4/26 9:04
 **/
public class FunctionTest {

    /**
     * Consumer
     * @param consumer
     */
    public void newActiveInfo(ActiveUserVo activeUserVo, Consumer<ActiveUserVo> consumer) {
        activeUserVo.setCustomerNo(81000354L);
        activeUserVo.setActiveNo("T12344545665");
        activeUserVo.setCustomerNoDemo(11105454L);
        Consumer<ActiveUserVo> consumer2=(s)->{
            s.setCustomerNo(91000000L);
            System.out.println("S="+s.toString());
        };
        //这说明consumer可以修改传入对象的内部值，以便于后续继续操作
        //这里有一点需要注意，调用accept()方法的时候才会执行代码，andThen只是把代码的逻辑组合起来
        consumer.andThen(consumer2).accept(activeUserVo);
    }


    /**
     * Function
     * @param activeUserVo
     * @param function
     * @return
     */
    private int executeFunction(ActiveUserVo activeUserVo, Function<ActiveUserVo, Integer> function) {
        activeUserVo.setCustomerNo(81000354L);
        activeUserVo.setActiveNo("T12344545665");
        activeUserVo.setCustomerNoDemo(11105454L);
        return function.apply(activeUserVo);
    }

    /**
     * BiFunction
     * @param activeUserVo
     * @param function
     * @return
     */
    private int executeBiFunction(ActiveUserVo activeUserVo, BiFunction<ActiveUserVo,ActiveUserVo, Integer> function) {
        activeUserVo.setCustomerNo(81000354L);
        activeUserVo.setActiveNo("T12344545665");
        activeUserVo.setCustomerNoDemo(11105454L);
        return function.apply(activeUserVo,activeUserVo);
    }

    public static void main(String... args) {
        FunctionTest functionTest=new FunctionTest();
        List<ActiveUserVo> list = new ArrayList();
        ActiveUserVo activeUserVo2=new ActiveUserVo();
        functionTest.newActiveInfo(activeUserVo2,activeUserVo ->list.add(activeUserVo));
        System.out.println(activeUserVo2.toString());
        System.out.println(list.toString());

        functionTest.executeFunction(activeUserVo2, (x) -> {
            System.out.println("x="+x);
          return 1;
        });

        functionTest.executeBiFunction(activeUserVo2, (x,y) -> {
            System.out.println("x="+x);
            System.out.println("y="+y);
            return 1;
        });
    }
}
