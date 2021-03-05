package com.southwind.entity;

import lombok.Data;

import java.lang.reflect.Type;

@Data
public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
}
