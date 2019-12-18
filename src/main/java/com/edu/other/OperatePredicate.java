package com.edu.other;

/**
 * OperatePredicate
 *
 * @author:
 * @create: 2019-12-16
 **/
public interface OperatePredicate<T, R> {

    R getValue(T t1, T t2);
}
