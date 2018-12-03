package com.company;

public class Animal implements CanFly, CanRun, CanSwim{
    private String name;
    private int speed;

    Animal(String name, int speed){
        this.name = name;
        if(speed >= 0){
            this.speed = speed;
        }else{
            this.speed = 0;
        }
    }

    Animal(){}

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void fly() {
        System.out.println("Animal can fly");
    }

    @Override
    public void run() {
        System.out.println("Animal can run");
    }

    @Override
    public void swim() {
        System.out.println("Animal can swim");
    }
}
