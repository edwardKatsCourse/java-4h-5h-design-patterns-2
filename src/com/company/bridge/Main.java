package com.company.bridge;

public class Main {
    public static void main(String[] args) {
        Color color = new Blue();
        Shape shape = new Square(color);

        System.out.println(shape.draw());


    }
}
