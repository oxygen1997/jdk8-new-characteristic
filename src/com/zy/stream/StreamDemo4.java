package com.zy.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流终止操作
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        /**
         * 非短路操作
         *      forEach/forEachOrdered
         *      collect/toArray
         *      reduce
         *      min/max/count
         * 短路操作
         *      findFirst/findAny
         *      allMatch/anyMarch/noneMatch
         */
        //forEachOrdered  保证迭代顺序
        String s = "my name is wuYanZu";
        //创建并行流，无序
        s.chars().parallel().forEach((i->System.out.println((char)i)));
        System.out.println("---------after Ordered--------");
        s.chars().parallel().forEachOrdered(i->System.out.println((char)i));

        //collect,将收集到的元素添加到list,或者set
        System.out.println("---------collect--------");
        List<String> collect = Stream.of(s.split(" ")).collect(Collectors.toList());
        System.out.println(collect);

        //使用collectors拼接字符串
        System.out.println("---------Collectors.joining--------");
        String str = Stream.of(s.split(" ")).collect(Collectors.joining("+"));
        System.out.println(str);

        //使用reduce拼接字符串
        System.out.println("---------reduce--------");
        Optional<String> result = Stream.of(s.split(" ")).reduce((s1, s2) -> s1 + " | " + s2);
        System.out.println(result.orElse(""));

        //使用reduce初始化值计算字符串长度
        System.out.println("---------reduce length--------");
        Integer iLen = Stream.of(s.split(" ")).map(s0->s0.length()).reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(iLen);

        //max的使用,返回最大值
        System.out.println("---------max--------");
        Optional<String> max = Stream.of(s.split(" ")).max((ss1, ss2) -> ss1.length() - ss2.length());
        System.out.println(max.get());
    }
}
