package com.model.builder;

// 建造者模式: 建造者模式是一种创建型模式，使你能够分步骤创建复杂对象，该模式允许你使用相同的创建代码生成不同类型和形式的对象
//通常情况下，构造器参数多的，通常会有无用的参数，这对构造函数的调用十分不简洁
public class Builder {
    //客户端: 必须将某个生成器对象与主管类联系
    public static void main(String[] args) {
        HouseBuilder builder = new BlueHouseBuilder();
        Director director = new Director();
        director.blue(builder);
        House house = builder.reset();
        System.out.println(house.toString());

    }
}



enum Walls{
    BLUE,BLACK,RED
}
enum Doors{
    BLUE,BLACK,RED
}
enum Windwos{
    BLUE,BLACK,RED
}
enum Roof{
    BLUE,BLACK,RED
}
enum Garge{
    BLUE,BLACK,RED
}
// 产品 : 最终生成的对象，由不同生成器构造的产品无需属于同一类层次结构或接口
class House{
    private Walls walls;
    private Doors doors;
    private Windwos windows;
    private Roof roof;
    private Garge garge;

    public House(Walls walls,Doors doors,Windwos windows,Roof roof,Garge garge){
        this.walls = walls;
        this.doors = doors;
        this.windows = windows;
        this.roof = roof;
        this.garge = garge;
    }

    public Walls getWalls() {
        return walls;
    }

    public void setWalls(Walls walls) {
        this.walls = walls;
    }

    public Doors getDoors() {
        return doors;
    }

    public void setDoors(Doors doors) {
        this.doors = doors;
    }

    public Windwos getWindows() {
        return windows;
    }

    public void setWindows(Windwos windows) {
        this.windows = windows;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public Garge getGarge() {
        return garge;
    }

    public void setGarge(Garge garge) {
        this.garge = garge;
    }

    @Override
    public String toString() {
        return "House{" +
                "walls=" + walls +
                ", doors=" + doors +
                ", windows=" + windows +
                ", roof=" + roof +
                ", garge=" + garge +
                '}';
    }
}
//建造者(生成器) : 接口所在所有类型生成器中通用的产品构造步骤
interface HouseBuilder{
    void builderWalls(Walls walls);
    void builderDoors(Doors doors);
    void builderWindwos(Windwos windwos);
    void builderRoof(Roof roof);
    void builderGarge(Garge garge);
    House reset();
}

//具体生成器(建造者): 提供构造过程的不同实现，具体生成器也可以构造不遵循通用接口的产品
class BlueHouseBuilder implements  HouseBuilder{
    private Walls walls;
    private Doors doors;
    private Windwos windows;
    private Roof roof;
    private Garge garge;

    public void builderWalls(Walls walls) {
        this.walls = walls;
    }

    public void builderDoors(Doors doors) {
        this.doors = doors;
    }

    public void builderWindwos(Windwos windwos) {
        this.windows = windwos;
    }

    public void builderRoof(Roof roof) {
        this.roof = roof;
    }

    public void builderGarge(Garge garge) {
        this.garge = garge;
    }

    public House reset() {
        return new House(walls,doors,windows,roof,garge);
    }
}


// 主管: 类定义调用构造步骤的顺序，这样就可以创建和复用特定的产品配置
class Director{

    public void blue(HouseBuilder builder){
        builder.builderWalls(Walls.BLUE);
        builder.builderDoors(Doors.BLUE);
        builder.builderGarge(Garge.BLUE);
        builder.builderRoof(Roof.BLUE);
        builder.builderWindwos(Windwos.BLUE);
    }
    public void Black(HouseBuilder builder){
        builder.builderWalls(Walls.BLACK);
        builder.builderDoors(Doors.BLACK);
        builder.builderGarge(Garge.BLACK);
        builder.builderRoof(Roof.BLACK);
        builder.builderWindwos(Windwos.BLACK);
    }
}





