package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameRatAndCat {
    public static void main(String[] args){
        Cat cat = new Cat("Tom", 10);
        Rat rat = new Rat("Jerry", 13, 10);

        if(cat.catchRat(rat)){
            System.out.println("Mèo Tom đã bắt được chuột Jerry");
        }else{
            System.out.println("Mèo Tom không bắt được chuột Jerry");
        }

        cat.eat(rat);

        Cat catBlue = new Cat("Blue", 20);
        Rat ratRed = new Rat("Red", 12, 10);
        Cat catGreen = new Cat("Green", 10);
        Rat ratYellow = new Rat("Yellow", 9, 10);
        Cat catWhite = new Cat("White", 10);
        Rat ratBlack = new Rat("Black", 9, 20);
        Cat catGrey = new Cat("Grey", 10);
        Rat ratPurple = new Rat("Purple", 15, 20);
        Rat ratOrange = new Rat("Orange", 10, 10);
        Rat ratPink = new Rat("Pink", 10, 10);

        List<Cat> catList = new ArrayList<>();
        catList.add(cat);
        catList.add(catBlue);
        catList.add(catGreen);
        catList.add(catGrey);
        catList.add(catWhite);
        List<Rat> ratList = new ArrayList<>();
        ratList.add(rat);
        ratList.add(ratRed);
        ratList.add(ratYellow);
        ratList.add(ratBlack);
        ratList.add(ratPurple);
        ratList.add(ratOrange);
        ratList.add(ratPink);

        System.out.println("Lấy ra con chuột bất kỳ: ");
        Rat randomRat = (Rat) getRandomAnimal(ratList);
        System.out.println(randomRat.toString());

        System.out.println("Lấy ra danh sách mèo được sắp xếp theo thứ tự a - z");
        getAnimalListAZ(catList);

        System.out.println("Lấy ra danh sách chuột được sắp xếp theo thứ tự a - z");
        getRandomAnimal(ratList);

        System.out.println("Mèo bắt chuột và in kết quả ra file text");
        catchingAllRats(catList, ratList);
        try {
            FileReader fileReader = new FileReader("C:\\Users\\huyho\\IdeaProjects\\FinalTestModulePF_Java\\result_cat_catch_rat.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    //Lấy ra một tên chuột bất kỳ trong danh sách
    public static Animal getRandomAnimal(List animalList){
        Random random = new Random();
        if(animalList.size() > 1) {
            int index = random.nextInt(animalList.size() - 1);
            return (Animal) animalList.get(index);
        }else{
            return (Animal) animalList.get(0);
        }
    }

    //Hiển thị danh sách động vật theo thứ tự a - z
    public static void getAnimalListAZ(List animalList){
        Animal[] animalArray = new Animal[animalList.size()];
        for(int i = 0; i < animalList.size(); i++){
            animalArray[i] = (Animal) animalList.get(i);
        }
        for(int i = 0; i < animalArray.length; i++){
            for(int j=1; j < (animalArray.length-i); j++){
                if(animalArray[j-1].getName().charAt(0) > animalArray[j].getName().charAt(0)){
                    //swap elements
                    Animal temp = animalArray[j-1];
                    animalArray[j-1] = animalArray[j];
                    animalArray[j] = temp;
                }

            }
        }
        animalList.clear();
        for(int i = 0; i < animalArray.length; i++){
            animalList.add(animalArray[i]);
        }
        for(int i = 0; i < animalList.size(); i++){
            System.out.println(animalList.get(i).toString());
        }
    }

    //cho mèo bắt hết chuột và in kết quả ra file text
    public static void catchingAllRats(List<Cat> catList, List<Rat> ratList){
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\huyho\\IdeaProjects\\FinalTestModulePF_Java\\result_cat_catch_rat.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (int i = 0; i < ratList.size(); i++) {
                Rat rat = (Rat) getRandomAnimal(ratList);
                Cat cat = (Cat) getRandomAnimal(catList);
                if (cat.catchRat(rat)) {
                    ratList.remove(rat);
                    printWriter.write(cat.toString()+" -bắt- "+rat.toString()+"\n");
                    printWriter.println();
                }
            }
            if(ratList.size() > 0){
                catchingAllRats(catList, ratList);
            }
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Success in writing file");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
