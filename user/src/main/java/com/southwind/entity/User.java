package com.southwind.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private String nickname;
    private String gender;
    private String telepone;
    private Date registerdate;
    private String address;
}
