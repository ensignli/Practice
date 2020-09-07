package com.test.fatherson;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/5/12 10:56
 **/
public class Son extends Base {
    private static int i = 3;

    /**
     * 构造函数没有返回值类型
     */
    private Son() {
        this.setI(i);
        //super.i = 4;
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.display();
    }
}
