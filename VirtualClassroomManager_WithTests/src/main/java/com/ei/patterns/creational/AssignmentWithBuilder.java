package com.ei.patterns.creational;

import java.time.LocalDate;
import java.util.List;

public class AssignmentWithBuilder {
    private final String title;
    private final LocalDate dueDate;
    private final String description;
    private final List<String> attachments;
    private final int allowedLateDays;

    private AssignmentWithBuilder(Builder builder) {
        this.title = builder.title;
        this.dueDate = builder.dueDate;
        this.description = builder.description;
        this.attachments = builder.attachments;
        this.allowedLateDays = builder.allowedLateDays;
    }

    public String getTitle() { return title; }
    public LocalDate getDueDate() { return dueDate; }
    public String getDescription() { return description; }
    public java.util.List<String> getAttachments() { return attachments; }
    public int getAllowedLateDays() { return allowedLateDays; }

    @Override
    public String toString() {
        return "Assignment{" +
                "title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", description='" + description + '\'' +
                ", attachments=" + attachments +
                ", allowedLateDays=" + allowedLateDays +
                '}';
    }

    public static class Builder {
        private String title;
        private LocalDate dueDate;
        private String description;
        private List<String> attachments;
        private int allowedLateDays = 0;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAttachments(List<String> attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder setAllowedLateDays(int allowedLateDays) {
            this.allowedLateDays = allowedLateDays;
            return this;
        }

        public AssignmentWithBuilder build() {
            if (title == null || title.isBlank()) throw new IllegalStateException("Title is required");
            if (dueDate == null) throw new IllegalStateException("Due date is required");
            return new AssignmentWithBuilder(this);
        }
    }
}
