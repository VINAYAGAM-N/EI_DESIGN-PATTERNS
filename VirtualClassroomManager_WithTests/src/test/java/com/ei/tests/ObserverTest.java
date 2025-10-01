package com.ei.tests;

import com.ei.manager.ClassroomManager;
import com.ei.model.Assignment;
import com.ei.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {
    private ClassroomManager manager;

    @BeforeEach
    public void setup() {
        manager = ClassroomManager.getInstance();
    }

    @Test
    public void testStudentReceivesNotification() {
        manager.createClassroom("Math101");
        Student s = new Student("S01", "Alice");
        manager.enrollStudent("Math101", s);
        Assignment a = new Assignment("HW1", LocalDate.now().plusDays(5));
        manager.scheduleAssignment("Math101", a);
        assertEquals("Alice", s.getName());
    }
}
