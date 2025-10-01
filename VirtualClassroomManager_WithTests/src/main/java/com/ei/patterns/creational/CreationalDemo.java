package com.ei.patterns.creational;

import com.ei.model.Assignment;
import com.ei.model.Classroom;
import com.ei.model.Student;

import java.time.LocalDate;
import java.util.Arrays;

public class CreationalDemo {
    public static void main(String[] args) {
        Student s = EntityFactory.createStudent("S01", "Alice");
        Classroom c = EntityFactory.createClassroom("Math101");
        Assignment a = EntityFactory.createAssignment("HW1", LocalDate.of(2025, 9, 30));

        System.out.println("Factory created student: " + s.getId() + " " + s.getName());
        System.out.println("Factory created classroom: " + c.getName());
        System.out.println("Factory created assignment: " + a);

        AssignmentWithBuilder complex = new AssignmentWithBuilder.Builder()
                .setTitle("Project1")
                .setDueDate(LocalDate.of(2025, 10, 15))
                .setDescription("Final project on design patterns")
                .setAttachments(Arrays.asList("spec.pdf", "guidelines.docx"))
                .setAllowedLateDays(2)
                .build();

        System.out.println("Builder created assignment: " + complex);
    }
}
