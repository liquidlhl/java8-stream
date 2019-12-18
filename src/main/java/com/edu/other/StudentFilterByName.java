package com.edu.other;

import com.edu.entity.Student;

/**
 * StudentFilterByAge
 *
 * @author:
 * @create: 2019-12-16
 **/
public class StudentFilterByName implements MyPredicate<Student> {

    @Override
    public boolean test(Student student) {
        return student.getName().contains("s");
    }
}
