package com.company;

public class Cat extends Animal{

    Cat(String name, int speed){
        super(name, speed);
    }

    public void run(){
        System.out.println("Mèo đang chạy với tốc độ "+getSpeed());
    }

    @Override
    public void fly() {
        System.out.println("Mèo không bay được");
    }

    @Override
    public void swim() {
        System.out.println("Mèo không biết bơi");
    }

    public boolean catchRat(Rat rat){
        //mèo bắt được chuột khi tốc độ mèo bằng tốc độ chuột
        if(getSpeed() >= rat.getSpeed()){
            return true;
        }
        return false;
    }

    public void eat(Rat food){
        if(catchRat(food)){
            if(food.getWeight() < 10){
                System.out.println("Mum mum, chuột hơi gầy");
            }else if (food.getWeight() > 10){
                System.out.println("Mum mum, chuột béo đấy");
            }else{
                System.out.println("Mum mum, chuột vừa miếng đấy");
            }
        }else{
            System.out.println("Meo meo, đói");
        }
    }

    @Override
    public String toString() {
        return "Mèo tên là: "+getName()+", tốc độ là: "+getSpeed();
    }
}
