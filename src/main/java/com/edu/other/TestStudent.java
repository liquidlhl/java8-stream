package com.edu.other;

import com.edu.entity.Student;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * TestStudent
 *
 * @author:
 * @create: 2019-07-30
 **/
public class TestStudent {


    @Test
    public void TestFilterByAge() {
        List<Student> list = Arrays.asList(
                new Student("s1", 18),
                new Student("s2", 51),
                new Student("s3", 14),
                new Student("s4", 11)
        );
        // 策略模式
        List<Student> students = filterStudent(list, new StudentFilterByAge());
        for (Student student : students) {
            System.out.println("student = " + student);
        }

        List<Student> students2 = filterStudent(list, new StudentFilterByName());
        for (Student student : students2) {
            System.out.println("student = " + student);
        }

        //lambda 表达式
        List<Student> list1 = filterStudent(list, (e) -> e.getName().contains("s"));

        Collections.sort(list,(x,y)->{
            if(x.getAge()==y.getAge()){
                return x.getName().compareTo(y.getName());
            }
            return x.getAge().compareTo(x.getAge());
        });

    }


    // 策略模式
    public List<Student> filterStudent(List<Student> list, MyPredicate<Student> myPredicate) {
        List<Student> res = new ArrayList<>();
        for (Student student : list) {
            boolean test = myPredicate.test(student);
            if (test) {
                res.add(student);
            }
        }
        return res;
    }

    @Test
    public void test() {
        //语法： 一个参数，无返回值
        //consumer接口的实现类
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("tt");

        //语法，两个以上参数，有返回值
        Comparator<Integer> comparte = (x,y) -> Integer.compare(x,y);

        int compare = comparte.compare(1, 40);
        System.out.println("compare = " + compare);


    }


    @Test
    public void testOperator() {
        Integer op1 = op(23, 41, (x, y) -> x + y);
        System.out.println("op1 = " + op1);
        Integer op = op(3, 5, (x, y) -> x * y);
        System.out.println("op = " + op);

    }


    public Integer op(Integer t1,Integer t2,OperatePredicate<Integer,Integer> op){
       return op.getValue(t1,t2);
    }

}
