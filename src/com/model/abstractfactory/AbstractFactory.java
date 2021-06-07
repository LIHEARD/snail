package com.model.abstractfactory;
//静态工厂方法模式: 是一种创建型设计模式，它能创建一系列相关的对象，而无需指定其具体类
public class AbstractFactory {
    //尽管具体工厂会对具体产品进行初始化，其构建方法签名必须返回相应的抽象产品，
    // 这样使用工厂类的客户端代码就不会与工厂创建的特定产品耦合
    //客户端:客户端只需通过抽象接口调用工厂和产品对象，就能与任何具体工厂/产品变体交互
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new ModrenFactory();
        FurnitureFactory furnitureFactory1 = new RetorFactory();
        Chair chair = furnitureFactory.createChair();
        Table table = furnitureFactory.createTable();
        Chair chair1 = furnitureFactory1.createChair();
        Table table1 = furnitureFactory1.createTable();
        chair.sitOn();
        chair1.sitOn();
        table.put();
        table1.put();
    }
}
//抽象产品 : 为构成系列产品的一组不同但相关的产品接口声明
//椅子接口
interface  Chair{
    void sitOn();
}
//桌子接口
interface Table{
    void put();
}
// 具体产品: 是抽象产品的多种不同类型的实现，所有变体都必须实现相应的抽象产品
//现代风格椅子、桌子
class ModrenChair implements Chair{

    public void sitOn() {
        System.out.println("现代风格椅子坐");
    }
}

//现代风格桌子
class ModrenTable implements  Table{

    public void put() {
        System.out.println("现代桌子放");
    }
}
//复古风格
class RetortChair implements  Chair{
    public void sitOn() {
        System.out.println("复古风格椅子坐");
    }
}
class RetortTable implements Table{
    public void put() {
        System.out.println("复古桌子放");
    }
}

//抽象工厂: 接口声明了一组创建各种抽象产品的方法
interface  FurnitureFactory{
    Chair createChair();
    Table createTable();
}

//具体工厂: 实现抽象工厂的构建方法，每个具体都对应特定产品变体，且仅创建此种产品变体
class RetorFactory implements FurnitureFactory{
    public Chair createChair() {
        return new RetortChair();
    }

    public Table createTable() {
        return new RetortTable();
    }
}


class ModrenFactory implements  FurnitureFactory{

    public Chair createChair() {
        return new ModrenChair();
    }

    public Table createTable() {
        return new ModrenTable();
    }
}


