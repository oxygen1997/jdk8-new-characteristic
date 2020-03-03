package com.zy.lambda;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class Lambda1 {
    interface MyInter{
        int add(int x,int y);
        //默认方法；jdk8新特性
        default void print(){
            System.out.println("print default void method...");
        };
        //静态默认方法；jdk8新特性
        static  void println(){
            System.out.println("print static void method...");
        }
    };
    public static void main(String[] args) {
        MyInter i = (x,y) -> x+y;
        System.out.println("MyInter.add："+i.add(1,2));
        i.print();
        MyInter.println();
        //无参lambda表达式
        Runnable noArgs = () -> System.out.println("No args lambda.");
        //单个参数lambda表达式
        ActionListener oneArgs = event -> System.out.println("One args lambda.");
        //代码块
        Runnable codeBlock = () -> {
            System.out.println("code block 1.");
            System.out.println("code block 2.");
        };
        //多个参数推断参数类型
        BinaryOperator<Integer>  manyArgs = (x,y) -> x+y;
        //多个参数显示指参数类型
        BinaryOperator<Integer>  manyArgs1 = (Integer x,Integer y) -> x-y;

        new Thread(noArgs).start();
        new Thread(()-> {System.out.println("Runnable 1...");
            System.out.println("Runnable 1.1");}).start();
        new Thread(()-> {System.out.println("Runnable 2...");
            System.out.println("Runnable 2.1");}).start();
    }
}
