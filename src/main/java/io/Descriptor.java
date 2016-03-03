package io;

import java.io.Serializable;

/**
 * Created by User on 03.03.2016.
 */
public class Descriptor implements Serializable {
    private final String name;
    private final int age;

    public Descriptor(String name, int age){
        this.name = name;
        this.age = age;

    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString(){
        return "Descriptor{" +
                "name='" + name +
                ", age=" + age +
                "}";
    }
}
