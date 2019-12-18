package com.edu.stream;

import com.edu.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * TestMap
 *
 * @author:
 * @create: 2019-12-17
 **/

public class TestMap {
    /*

    映射
    map一接收Lambda,将元素转换成其他形式或提取信息。接收一个函数作为参数,该函数会被应用到每个元素上,并将其映射成一个新的元素
    f1atMap接收一个函数作为参数,将流中的每个值都换成另一个流,然后把所有流连接成一个流
    flatMap: 将map中的元素视为流来处理，将每个流中的元素取出，放入一个新的流
    ref:https://www.cnblogs.com/diegodu/p/8794857.html

    */

    @Test
    public void test() {
        List<Student> list = Arrays.asList(
                new Student("s1", 11),
                new Student("s1", 51),
                new Student("s3", 14),
                new Student("s4", 11),
                new Student("t5", 66),
                new Student("t6", 77)
        );

        list.stream().map((Student::getName)).forEach(out::println);


        List<String> l1 = Arrays.asList(
                "s1", "s2"
        );

        List<String> l2 = Arrays.asList(
                "s3", "s4"
        );
        List<String> l3 = Arrays.asList(
                "s5"
        );
        List<List<String>> listAll = Arrays.asList(l1, l2, l3);

        List<String> collect = listAll.stream()
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);


    }

}
