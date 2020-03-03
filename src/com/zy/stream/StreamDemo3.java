package com.zy.stream;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 流中间操作
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        /**
         * 无状态操作
         *      map/mapToXXX
         *      flatMap/flatMapToXXX
         *      filter
         *      peek
         *      unOrdered
         * 有状态操作
         *      distinct
         *      sorted
         *      limit/skip
         */
        //筛选长度大于2的字符串
        String s = "My name is WuYanzu";
        Stream.of(s.split(" ")).filter(s1->s1.length()>2).map(s1 -> s1.length()).forEach(System.out::println);

        //peek 用于debug 和foreach类似
        System.out.println("------------peek-------------");
        Stream.of(s.split(" ")).peek(System.out::println).forEach(System.out::println);

        //limit  使用，用于限制无限流
        System.out.println("------------limit-------------");
        new Random().ints().filter(i->i>=0&&i<1000).limit(5).forEach(System.out::println);

        //distinct  用于去重
        System.out.println("------------distinct-------------");
        String[] str = new String[]{"a","a","c"};
        Arrays.stream(str).distinct().forEach(System.out::println);

    }
}
