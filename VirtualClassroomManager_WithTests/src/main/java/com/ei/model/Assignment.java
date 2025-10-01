package com.ei.model;

import java.time.LocalDate;

public class Assignment {
    private final String title;
    private LocalDate dueDate;

    public Assignment(String title, LocalDate dueDate) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title required");
        if (dueDate == null) throw new IllegalArgumentException("Due date required");
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getTitle() { return title; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        return title + " (due: " + dueDate + ")";
    }
}
