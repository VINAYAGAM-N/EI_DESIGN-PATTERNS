package com.ei.patterns.structural.content;

import java.util.ArrayList;
import java.util.List;

public class Course implements ContentComponent {
    private final String title;
    private final List<ContentComponent> modules = new ArrayList<>();

    public Course(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Course title required");
        this.title = title;
    }

    public void add(ContentComponent c) {
        if (c == this) throw new IllegalArgumentException("Cannot add course to itself");
        modules.add(c);
    }

    public void remove(ContentComponent c) {
        modules.remove(c);
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public int getDurationMinutes() {
        int sum = 0;
        for (ContentComponent c : modules) sum += c.getDurationMinutes();
        return sum;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Course: " + title + " (total " + getDurationMinutes() + " min)"); 
        for (ContentComponent c : modules) c.print(indent + "  ");
    }
}
