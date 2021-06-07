package com.model.adapter;

import java.util.Arrays;

//适配器模式:
public class Adapter {

}

//美国插头
class USAPlug{
    private String plugA;
    private String plugB;
    private String plugC;


    public String getPlugA() {
        return plugA;
    }

    public void setPlugA(String plugA) {
        this.plugA = plugA;
    }

    public String getPlugB() {
        return plugB;
    }

    public void setPlugB(String plugB) {
        this.plugB = plugB;
    }

    public String getPlugC() {
        return plugC;
    }

    public void setPlugC(String plugC) {
        this.plugC = plugC;
    }

    @Override
    public String toString() {
        return "USAPlug{" +
                "plugA='" + plugA + '\'' +
                ", plugB='" + plugB + '\'' +
                ", plugC='" + plugC + '\'' +
                '}';
    }
}
//德国插头
class GPlug{
    private String plugA;
    private String plugB;
    private String plugC;


    public String getPlugA() {
        return plugA;
    }

    public void setPlugA(String plugA) {
        this.plugA = plugA;
    }

    public String getPlugB() {
        return plugB;
    }

    public void setPlugB(String plugB) {
        this.plugB = plugB;
    }

    public String getPlugC() {
        return plugC;
    }

    public void setPlugC(String plugC) {
        this.plugC = plugC;
    }

    @Override
    public String toString() {
        return "GPlug{" +
                "plugA='" + plugA + '\'' +
                ", plugB='" + plugB + '\'' +
                ", plugC='" + plugC + '\'' +
                '}';
    }
}
// 用插头插入插板中,此时为美国，需要使用美国插头，而德国插头不匹配，则需要使用适配器
class UseService{
    public void UsePlug(USAPlug usaPlug){
        System.out.println(usaPlug.toString());
    }
}

//适配器类
class PlugAdapter extends UseService{
    public void UsePlug(){
    }
}


