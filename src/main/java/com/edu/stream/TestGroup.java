package com.edu.stream;

import com.edu.entity.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TestGroup
 *
 * @author:
 * @create: 2019-12-17
 **/
public class TestGroup {

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

        //分组 按照age分组
        Map<Integer, List<Student>> groupByAge = list.stream().collect(Collectors.groupingBy(Student::getAge));
        System.out.println("groupByAge = " + groupByAge);

        //多级分组
        //先按name分组 再按age分组
        Map<String, Map<String, List<Student>>> groupByNameAge = list.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(e -> {
                            if (e.getAge() < 20) {
                                return "幼年";
                            } else if (e.getAge() < 50) {
                                return "中年";
                            } else if (e.getAge() < 100) {
                                return "老年";
                            }
                            return "unknown";
                        }
                )));
        System.out.println("groupByNameAge = " + groupByNameAge);

        //分区
        Map<Boolean, List<Student>> partition = list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 10));
        System.out.println("partition = " + partition);
        list.stream().collect(Collectors.partitioningBy(e -> e.getName().contains("s"))).forEach((flag, e)->{
            if(flag){
                System.out.println("s = " + e);
            }else{
                System.out.println("t = " + e);
            }
        });

        //统计信息
        DoubleSummaryStatistics summary = list.stream().collect(Collectors.summarizingDouble(Student::getAge));
        double max = summary.getMax();
        double min = summary.getMin();
        double average = summary.getAverage();
        System.out.println("summary = " + summary);

        //连接
        String join = list.stream().map(Student::getName)
                .collect(Collectors.joining("|"));
        System.out.println("join = " + join);


    }

}
