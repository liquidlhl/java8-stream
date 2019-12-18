package com.edu.entity;

import lombok.Data;

/**
 * Trader
 *
 * @author:
 * @create: 2019-12-17
 **/
@Data
public class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
