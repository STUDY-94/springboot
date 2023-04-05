package com.spring.boot.springboot.mock;

import java.util.List;

public class Animal {

    private String name;
    private int age;
    private Boolean isFly;
    List<String> animalList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getFly() {
        return isFly;
    }

    public void setFly(Boolean fly) {
        isFly = fly;
    }

    public List<String> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<String> animalList) {
        this.animalList = animalList;
    }
}
