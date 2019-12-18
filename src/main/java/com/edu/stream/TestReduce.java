package com.edu.stream;

import com.edu.entity.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TestReduce
 *
 * @author:
 * @create: 2019-12-17
 **/
public class TestReduce {


/*

    归约
    reduce(identity, BinaryOperator)/ reduce(BinaryOperator)可以将流中元素反复结合起来,得到一个值

    收集
    collect将流转换为其他形式接收一个 Collector接口的实现,用于给 Stream中元素做汇总的方法
*/

    @Test
    public void test() {
        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Integer reduce = asList.stream().reduce(0, (x, y) -> x + y);
        System.out.println("reduce = " + reduce);

        List<Student> list = Arrays.asList(
                new Student("s1", 11),
                new Student("s2", 51),
                new Student("s3", 14),
                new Student("s4", 11),
                new Student("t5", 66),
                new Student("t6", 77)
        );

        List<String> collect = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println("collect = " + collect);

        Set<String> set1 = list.stream().map(Student::getName).collect(Collectors.toSet());
        System.out.println("set1 = " + set1);

        Set<String> set2 = list.stream().map(Student::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println("set2 = " + set2);

        //总数
        Long count = list.stream().map(Student::getAge).collect(Collectors.counting());
        System.out.println("count = " + count);

        //平均值
        Double avg = list.stream().collect(Collectors.averagingDouble(Student::getAge));
        System.out.println("avg = " + avg);

        Optional<Integer> minby = list.stream().map(Student::getAge).collect(Collectors.minBy(Integer::compare));
        System.out.println("minby = " + minby.get());

        Optional<Integer> maxBy = list.stream().map(Student::getAge).collect(Collectors.maxBy(Integer::compare));
        System.out.println("maxBy = " + maxBy.get());

        //总和
        Double sum = list.stream().collect(Collectors.summingDouble(Student::getAge));
        System.out.println("sum = " + sum);





    }
}
