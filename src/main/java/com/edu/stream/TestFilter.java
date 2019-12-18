package com.edu.stream;

import com.edu.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TestFilter
 *
 * @author:
 * @create: 2019-12-17
 **/
public class TestFilter {
/*

    筛选与切片
    f11ter一接收Lambda,从流中排除某些元素
    1imit—截断流,使其元素不超过给定数量
    skip(n)一跳过元素,返回一个扔掉了n个元素的流。若流中元素不足n个,则返回一个空流与1imit(n)互补
    distinct一筛选,通过流所生成元素的 hashCode()和 equals()去除重复元素
*/

    @Test
    public void test() {
        //筛选与切片
        List<Student> list = Arrays.asList(
                new Student("s1", 18),
                new Student("s2", 51),
                new Student("s3", 14),
                new Student("s4", 11)
        );
        //过滤
        list.stream()
                .filter(x -> x.getName().contains("1"))
                .distinct()
                .forEach(System.out::println);

        list.stream()
                .filter(x -> !(x.getName().contains("1")))
                .limit(1)
                .forEach(System.out::println);

        list.stream()
                .filter(x -> !(x.getName().contains("1")))
                .skip(1)
                .forEach(System.out::println);

    }
}
