package com.model.singleton;

//单例模式: 是一种创建型设计模式，让你能够保证一个类只有一个实例，并且提供一个访问该实例的全局节点

public class Singleton {

    private static volatile Singleton singleton;

    public String value;

    private Singleton(String value){
        this.value = value;
    }

    public static Singleton getInstance(String value){
        Singleton result = singleton;
        if(result != null){
            return result;
        }
        synchronized (Singleton.class){
            if(singleton == null){
                singleton = new Singleton(value);
            }
            return singleton;
        }
    }
}
