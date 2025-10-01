package com.ei.patterns.structural.graphics_flyweight;
import java.util.ArrayList; import java.util.List;
public class Canvas {
    private final List<Icon> placed = new ArrayList<>();
    public void place(String iconId){ placed.add(IconFactory.getIcon(iconId)); }
    public void render(){ placed.forEach(i -> System.out.println("Rendering " + i)); System.out.println("Pool size: " + IconFactory.poolSize()); }
}
