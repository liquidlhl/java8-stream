package com.edu.other;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * TestFunctionInterface
 *
 * @author:
 * @create: 2019-12-16
 **/
public class TestFunctionInterface {


    /*

    Consumer<T> 消费型接口
        void accept(T t)

    Supplier<T> 供给型接口
        T get()

    Function<T,R> 函数型接口
        R get(T t)

    Predicate<T> 断言型接口
        boolean test(T t)

     */
    @Test
    public void test() {

        consume(1, x -> System.out.println("x = " + x));

        List<Integer> apply = get(5, () -> (int) (Math.random() * 100));
        apply.forEach(System.out::println);

        String string = "\t\t helloworld  \t\t";
        String apply1 = apply(string, x -> x.trim());
        System.out.println("apply1 = " + apply1);

    }


    public String apply(String s,Function<String,String> function){
       return function.apply(s);

    }

    // 指定个数生成元素 并放入集合中
    public List<Integer> get(Integer i, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add(supplier.get());
        }
        return list;

    }

    public void consume(Integer i, Consumer<Integer> consumer) {
        consumer.accept(i);
    }


}
