package com.duming.entity;

import org.apache.ibatis.type.Alias;

@Alias("user")
public class User {
    private int id;
    private String name;
    private  String passwod;

    public User() {
    }

    public User(int id, String name, String passwod) {
        this.id = id;
        this.name = name;
        this.passwod = passwod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswod() {
        return passwod;
    }

    public void setPasswod(String passwod) {
        this.passwod = passwod;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwod='" + passwod + '\'' +
                '}';
    }
}
