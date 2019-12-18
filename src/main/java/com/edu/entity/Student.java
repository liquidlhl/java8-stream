package com.edu.entity;

import lombok.Data;

/**
 * Student
 *
 * @author:
 * @create: 2019-07-30
 **/
@Data
public class Student {

    public String name;
    public Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
