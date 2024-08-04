package com.example.practicejava.family;

import lombok.ToString;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication


public class arrayPractice {

    public static void main(String[] args) {

        List<fruit> fruits = new ArrayList<>();
        fruit a = new fruit("사과", "빨간색");
        fruit b = new fruit("오렌지","주황색");
        fruit c = new fruit("바나나","노란색");
        fruit d = new fruit("포도","보라색");

        fruits.add(a);
        fruits.add(b);
        fruits.add(c);
        fruits.add(d);

        Set<fruit> fruitSet = new HashSet<>();

        for (fruit Fruit : fruits) {
            System.out.println(Fruit);
        }
    }
}

@ToString
class fruit {

    public fruit(String name, String color) {

        this.name = name;
        this.color = color;

    }

    private String name;
    private String color;

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
}