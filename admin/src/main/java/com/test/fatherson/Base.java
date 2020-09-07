package com.test.fatherson;

/**
 * @Description: TODO
 * @Author: spark
 * @Date: 2020/5/12 10:56
 **/
public class Base {
    public int i;

    public void setI(int i) {
        this.i = i;
    }


 /*   public Base(){
        System.out.println("Base this = " + this);
        System.out.println("Base i = " + this.i);
        this.display();
    }*/

    public void display(){
        System.out.println("Base display(i) = " + i);
        System.out.println("Base i = " +i);
    }
}
