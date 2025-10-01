package com.ei.tests;

import com.ei.model.Student;
import com.ei.model.Classroom;
import com.ei.model.Assignment;
import com.ei.patterns.creational.EntityFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    @Test
    public void testCreateStudent() {
        Student s = EntityFactory.createStudent("S01", "Bob");
        assertEquals("Bob", s.getName());
    }

    @Test
    public void testCreateClassroom() {
        Classroom c = EntityFactory.createClassroom("Science");
        assertEquals("Science", c.getName());
    }

    @Test
    public void testCreateAssignment() {
        Assignment a = EntityFactory.createAssignment("HW", LocalDate.now());
        assertEquals("HW", a.getTitle());
    }
}
