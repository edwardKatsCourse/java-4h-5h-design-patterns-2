package com.company.bridge;

public abstract class Shape {
    private Color color;

    public Color getColor() {
        return color;
    }

    public Shape(Color color) {
        this.color = color;
    }

    public abstract String draw();
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Drawing square. " + getColor().fill();
    }
}