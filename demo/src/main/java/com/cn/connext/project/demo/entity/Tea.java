package com.cn.connext.project.demo.entity;

public class Tea extends Drink {
    private String name;

    public void drinkTea(){
        System.out.println("喝茶");
    }

    @Override
    public void drink() {
        System.out.println("Tea重写Drink方法");
    }
    public void drink(Integer num){
        System.out.println("Tea重载Drink方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
