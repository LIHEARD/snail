package com.model.factory;

import java.util.List;

//工厂模式: 创建型设计模式，其在父类提供一个创建对象的方法，允许子类决定实例化对象的类型
// 不是用工厂模式时，产品和行为都糅合在一共类中，当需要添加一个海上运输时，则原有的功能类和car类耦合，需要重新修改源码
class Car {
    private int id;
    private String carName;
    private int shippingWeigh;
}
//此为功能类，当需要新增一个新的交通工具时，则，无法修改，需要重新对新增的交通工具新写方法
class Transport{
    public void transport(List<Car> carList,int weigh){
        //先判断运输重量，选择运输车种类
        for(Car car : carList){
            //业务逻辑
        }
    }
    public void transportForShop(List<Shop> shopList,int weight){
        //逻辑
    }
}
class Shop {
    private int id;
    private String shopName;
    private int shippingWeigh;
    //此时代码重复，此时业务逻辑相同，只是对象变了
    public void transport(List<Shop> carList,int weigh){
        //先判断运输重量，选择运输车种类
        for(Shop shopName : carList){
            if(shopName.shippingWeigh > weigh){
                System.out.println("可以运输");
            }
        }
    }
}

// 使用工厂模式
//产品: 将会对接口进行声明，对于所有由创建者及其子类构建的对象，这些接口都是通用的
interface Poduct{
    void transport();
}
//具体产品
class BigCarPoduct implements Poduct{
    public BigCarPoduct(){

    }

    public void transport() {
        System.out.println("big");
    }
}
class SmallCarPoduct implements Poduct{
    public void transport() {

    }
}
//创建者，创建者的职责不仅仅是创建对象，往往伴随者业务逻辑
abstract class MeansTransport{
    //如果靠参数决定工厂方法的话就需要新建个关联对象
    abstract Poduct create();
}
//具体创建者，汽车创建者,汽车分为大汽车、小汽车，通过传入参数决定
class CarFactory extends MeansTransport{

    //具体创建者应该为静态方法
    public Poduct create() {
        System.out.println("创建");
        return  new BigCarPoduct();
    }
}

//客户
public class Factory{
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Poduct poduct = carFactory.create();
        poduct.transport();
    }
}