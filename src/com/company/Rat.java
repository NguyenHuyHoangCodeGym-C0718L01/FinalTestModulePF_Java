package com.company;

public class Rat extends Animal{
    private int weight; //cân nặng

    Rat(String name, int weight, int speed){
       super(name, speed);
        if(weight > 0) {
            this.weight = weight;
        }else{
            this.weight = 1;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void run(){
        System.out.println("Chuột đang chạy với tốc độ "+getSpeed());
    }

    @Override
    public void fly() {
        System.out.println("Chuột không biết bay");
    }

    @Override
    public void swim() {
        System.out.println("Chuột biết bơi");
    }

    @Override
    public String toString() {
        return "Chuột: [tên: "+getName()+", cân nặng: "+weight+", tốc độ chạy: "+getSpeed();
    }
}
