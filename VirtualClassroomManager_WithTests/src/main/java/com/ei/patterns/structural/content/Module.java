package com.ei.patterns.structural.content;

import java.util.ArrayList;
import java.util.List;

public class Module implements ContentComponent {
    private final String title;
    private final List<ContentComponent> children = new ArrayList<>();

    public Module(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Module title required");
        this.title = title;
    }

    public void add(ContentComponent c) {
        if (c == this) throw new IllegalArgumentException("Cannot add module to itself");
        children.add(c);
    }

    public void remove(ContentComponent c) {
        children.remove(c);
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public int getDurationMinutes() {
        int sum = 0;
        for (ContentComponent c : children) sum += c.getDurationMinutes();
        return sum;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Module: " + title + " (total " + getDurationMinutes() + " min)"); 
        for (ContentComponent c : children) c.print(indent + "  ");
    }
}
