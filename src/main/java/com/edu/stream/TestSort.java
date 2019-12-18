package com.edu.stream;

import com.edu.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * TestSort
 *
 * @author:
 * @create: 2019-12-17
 **/
public class TestSort {
/*
    排序
    sorted（）一自然排序
    sorted(Comparator com)一定制排序

*/
    @Test
    public void test() {

        List<String> list = Arrays.asList(
                "eee",
                "aaa",
                "bbb",
                "ccc",
                "ddd"
        );

        list.stream().sorted().forEach(System.out::println);

        List<Student> list1 = Arrays.asList(
                new Student("s1", 18),
                new Student("s2", 51),
                new Student("s3", 14),
                new Student("s4", 11)
        );

        list1.stream()
                .sorted((e1, e2) -> {
                    return e1.getAge().compareTo(e2.getAge());
                }).forEach(System.out::println);

        list1.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);


    }
}
