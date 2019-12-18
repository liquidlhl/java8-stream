package com.edu.other;

import com.edu.entity.Student;

/**
 * StudentFilterByAge
 *
 * @author:
 * @create: 2019-12-16
 **/
public class StudentFilterByAge implements MyPredicate<Student> {

    @Override
    public boolean test(Student student) {
        return student.getAge() >= 18;
    }
}
