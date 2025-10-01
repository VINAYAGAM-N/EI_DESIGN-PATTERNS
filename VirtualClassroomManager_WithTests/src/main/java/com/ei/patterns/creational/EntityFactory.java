package com.ei.patterns.creational;

import com.ei.model.Assignment;
import com.ei.model.Classroom;
import com.ei.model.Student;

import java.time.LocalDate;
import java.util.UUID;

public class EntityFactory {
    public static Student createStudent(String id, String name) {
        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
        }
        return new Student(id, name);
    }

    public static Classroom createClassroom(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Classroom name required");
        }
        return new Classroom(name);
    }

    public static Assignment createAssignment(String title, LocalDate dueDate) {
        return new Assignment(title, dueDate);
    }
}
