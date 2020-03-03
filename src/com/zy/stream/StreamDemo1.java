package com.zy.stream;


import java.util.stream.IntStream;

public class StreamDemo1 {

    /**
     * stream流编程方法
     * 集合           Collection.stream/parallelStream
     * 数组           Arrays.stream
     * 数字           IntStream/LongStream.range/rangeClosed         Random.ints/longs/doubles
     * 自定义创建     Stream.generate/iterate
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        System.out.println("外部迭代："+sum);


        /**
         * stream类似与流水线操作，创建流，中间操作，终止操作
         * of方法为迭代的意思，sum即为终止操作
         * 执行中间操作
         * 区别中间操作和终止操作，当返回为stream流时，为中间操作，当返回为类型时，为终止操作。
         */
        sum = IntStream.of(arr).sum();
//        sum = IntStream.of(arr).map(i -> i * 3).sum();
        System.out.println("内部迭代："+sum);
    }

}
