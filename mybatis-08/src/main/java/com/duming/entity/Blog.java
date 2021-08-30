package com.duming.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private  String id;
    private  String title;
    private  String author;
    private Date creatTime;//属性名和字段名不一致
    private  int views;
}
