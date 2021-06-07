package com.entity;

import java.util.Optional;

public class Person {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Test1{
    public static void main(String[] args) {
        TestOptional testOptional = new TestOptional();
        // testOptional.setId("1");
        String s = Optional.ofNullable(testOptional).map(per -> per.getPerson()).map(person -> person.getName()).orElse(null);
         // System.out.println(s);
        System.out.println( Optional.ofNullable(testOptional).map(test -> test.getId()).orElse("数据为空"));
    }

}