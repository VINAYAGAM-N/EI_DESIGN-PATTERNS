package com.ei.patterns.structural.content;

public class Lesson implements ContentComponent {
    private final String title;
    private final int durationMinutes;

    public Lesson(String title, int durationMinutes) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Lesson title required");
        if (durationMinutes <= 0) throw new IllegalArgumentException("Duration must be positive");
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public int getDurationMinutes() { return durationMinutes; }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Lesson: " + title + " (" + durationMinutes + " min)"); 
    }
}
