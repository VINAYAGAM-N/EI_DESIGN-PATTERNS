package com.ei.patterns.structural;

import com.ei.patterns.structural.content.Course;
import com.ei.patterns.structural.content.Module;
import com.ei.patterns.structural.content.Lesson;

public class CompositeDemo {
    public static void main(String[] args) {
        Course course = new Course("Data Structures");

        Module m1 = new Module("Arrays");
        m1.add(new Lesson("Intro to arrays", 20));
        m1.add(new Lesson("Array operations", 40));

        Module m2 = new Module("Linked Lists");
        m2.add(new Lesson("Singly linked list", 30));
        m2.add(new Lesson("Doubly linked list", 35));

        course.add(m1);
        course.add(m2);

        course.print(""); // print hierarchy and totals
    }
}
