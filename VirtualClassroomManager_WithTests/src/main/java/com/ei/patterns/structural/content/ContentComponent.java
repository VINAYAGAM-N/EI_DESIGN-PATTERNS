package com.ei.patterns.structural.content;

public interface ContentComponent {
    String getTitle();
    int getDurationMinutes();
    void print(String indent);
}
