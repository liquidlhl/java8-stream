package com.edu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Transaction
 *
 * @author:
 * @create: 2019-12-17
 **/
@Data
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
