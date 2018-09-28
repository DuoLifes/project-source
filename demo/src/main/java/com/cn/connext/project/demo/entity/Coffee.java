package com.cn.connext.project.demo.entity;

public class Coffee extends Drink {
    private String name;

    public void drinkCoffee(){
        System.out.println("喝咖啡");
    }

    @Override
    public void drink() {
        System.out.println("Coffee重写Drink方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
