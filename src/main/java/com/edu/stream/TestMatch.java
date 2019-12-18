package com.edu.stream;

import com.edu.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * TestMatch
 *
 * @author:
 * @create: 2019-12-17
 **/
public class TestMatch {
/*
    查找与匹配
    allMatch—检查是否匹配所有元素
    anyMatch—检查是否至少匹配一个元素
    noneMatch—检查是否没有匹配所有元素
    findFirst—返回第一个元素
    findAny-—返回当前流中的任意元素
    count—返回流中元素的总个数
    max一返回流中最大值
    min一返回流中最小值
*/
    @Test
    public void test() {
        List<Student> list = Arrays.asList(
                new Student("s1", 18),
                new Student("s2", 51),
                new Student("s3", 14),
                new Student("s4", 11),
                new Student("t5", 66),
                new Student("t6", 77)
        );

        Boolean b1 = list.stream().allMatch(e -> e.getName().contains("s"));
        System.out.println("b1 = " + b1);

        Boolean b2 = list.stream().anyMatch(e -> e.getName().contains("s"));
        System.out.println("b2 = " + b2);

        boolean b3 = list.stream().noneMatch(e -> e.getName().contains("t"));
        System.out.println("b3 = " + b3);

        Optional<Student> first = list.stream().findFirst();
        System.out.println("first = " + first);

        Optional<Student> any = list.stream().findAny();
        System.out.println("any = " + any);

        long count = list.stream().count();
        System.out.println("count = " + count);

        Optional<Student> max = list.stream().max(Comparator.comparing(Student::getAge));
        System.out.println("max = " + max.get());

        Optional<Integer> max1 = list.stream()
                .map(Student::getAge)
                .max(Integer::compare);
        System.out.println("max1.get() = " + max1.get());


        Optional<Student> min = list.stream().min(Comparator.comparing(Student::getAge));
        System.out.println("min = " + min);


    }

}
