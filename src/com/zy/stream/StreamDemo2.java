package com.zy.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建流
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        //从集合创建
        //串行流
        list.stream();
        //并行流
        list.parallelStream();

        //从数组创建
        Arrays.stream(new int[]{1,2,3,4,5});

        //创建数字流  rangeClosed(StartIndex,size)
        IntStream.of(1,2,3);
//        IntStream.rangeClosed(1,10).forEach(System.out::println);

        //使用random创建随机流 limit(MaxSize)
//        new Random().ints().limit(10).forEach(System.out::println);
        Stream.generate(()->new Random().nextInt()).limit(10).forEach(System.out::println);

    }
}
