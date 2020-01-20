package com.company.bridge;

public abstract class Color {
    abstract String fill();
}

class Blue extends Color {

    @Override
    String fill() {
        return "Color is blue";
    }
}