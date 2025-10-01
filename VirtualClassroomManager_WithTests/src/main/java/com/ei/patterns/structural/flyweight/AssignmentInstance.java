package com.ei.patterns.structural.flyweight;

import java.time.LocalDate;

public class AssignmentInstance {
    private final String title;
    private final LocalDate dueDate;
    private final AssignmentTemplate template; // shared flyweight

    public AssignmentInstance(String title, LocalDate dueDate, AssignmentTemplate template) {
        this.title = title;
        this.dueDate = dueDate;
        this.template = template;
    }

    @Override
    public String toString() {
        return "AssignmentInstance{" + title + ", due=" + dueDate + ", template=" + template.getTemplateId() + "}";
    }
}
