package com.ei.patterns.structural.graphics_flyweight;
public class GraphicsDemo {
    public static void main(String[] args){
        Canvas c = new Canvas();
        c.place("smile"); c.place("smile"); c.place("heart"); c.render();
    }
}
