package com.ei.tests;

import com.ei.manager.ClassroomManager;
import com.ei.model.Student;
import com.ei.patterns.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CommandFunctionalityTest {
    private ClassroomManager manager;
    private CommandInvoker invoker;
    private CommandParser parser;

    @BeforeEach
    void setUp() {
        manager = ClassroomManager.getInstance();
        // Clear classrooms for clean test
        manager.clearClassrooms();
        invoker = new CommandInvoker();
        parser = new CommandParser();
    }

    @Test
    void testSubmitAssignmentValid() {
        // Setup
        manager.createClassroom("Math101");
        Student student = new Student("S01", "Alice");
        manager.enrollStudent("Math101", student);
        manager.scheduleAssignment("Math101", new com.ei.model.Assignment("HW1", LocalDate.now().plusDays(7)));

        // Execute
        Command cmd = parser.parse("submit_assignment S01 Math101 HW1");
        assertNotNull(cmd);
        invoker.executeCommand(cmd);

        // Verify
        assertTrue(student.getSubmittedAssignments().contains("HW1"));
    }

    @Test
    void testSubmitAssignmentInvalidAssignment() {
        // Setup
        manager.createClassroom("Math101");
        Student student = new Student("S01", "Alice");
        manager.enrollStudent("Math101", student);

        // Execute - command handles error internally
        Command cmd = parser.parse("submit_assignment S01 Math101 HW1");
        assertNotNull(cmd);
        invoker.executeCommand(cmd); // Should not throw, but print error
    }

    @Test
    void testSubmitAssignmentInvalidStudent() {
        // Setup
        manager.createClassroom("Math101");
        manager.scheduleAssignment("Math101", new com.ei.model.Assignment("HW1", LocalDate.now().plusDays(7)));

        // Execute - command handles error internally
        Command cmd = parser.parse("submit_assignment S01 Math101 HW1");
        assertNotNull(cmd);
        invoker.executeCommand(cmd); // Should not throw, but print error
    }

    @Test
    void testRemoveClassroom() {
        // Setup
        manager.createClassroom("Math101");

        // Execute - should succeed when no students or assignments
        Command cmd = parser.parse("remove_classroom Math101");
        assertNotNull(cmd);
        invoker.executeCommand(cmd);
    }

    @Test
    void testRemoveClassroomWithStudents() {
        // Setup
        manager.createClassroom("Math101");
        Student student = new Student("S01", "Alice");
        manager.enrollStudent("Math101", student);

        // Execute - should auto-confirm and force remove
        Command cmd = parser.parse("remove_classroom Math101");
        assertNotNull(cmd);
        invoker.executeCommand(cmd); // No exception thrown, force removed

        // Verify classroom is removed
        assertNull(manager.getClassroom("Math101"));
    }

    @Test
    void testRemoveClassroomWithAssignments() {
        // Setup
        manager.createClassroom("Math101");
        manager.scheduleAssignment("Math101", new com.ei.model.Assignment("HW1", java.time.LocalDate.now().plusDays(7)));

        // Execute - should auto-confirm and force remove
        Command cmd = parser.parse("remove_classroom Math101");
        assertNotNull(cmd);
        invoker.executeCommand(cmd); // No exception thrown, force removed

        // Verify classroom is removed
        assertNull(manager.getClassroom("Math101"));
    }

    @Test
    void testListStudents() {
        // Setup
        manager.createClassroom("Math101");
        Student student = new Student("S01", "Alice");
        manager.enrollStudent("Math101", student);

        // Execute
        Command cmd = parser.parse("list_students Math101");
        assertNotNull(cmd);
        invoker.executeCommand(cmd);

        // Verify - command executes without exception
    }

    @Test
    void testModifyAssignment() {
        // Setup
        manager.createClassroom("Math101");
        manager.scheduleAssignment("Math101", new com.ei.model.Assignment("HW1", LocalDate.now().plusDays(7)));

        // Execute
        Command cmd = parser.parse("modify_assignment Math101 HW1 2025-12-01");
        assertNotNull(cmd);
        invoker.executeCommand(cmd);
    }

    @Test
    void testOutOfBoxDuplicateSubmission() {
        // Setup
        manager.createClassroom("Math101");
        Student student = new Student("S01", "Alice");
        manager.enrollStudent("Math101", student);
        manager.scheduleAssignment("Math101", new com.ei.model.Assignment("HW1", LocalDate.now().plusDays(7)));

        // Submit once
        Command cmd1 = parser.parse("submit_assignment S01 Math101 HW1");
        invoker.executeCommand(cmd1);

        // Submit again - should allow or handle gracefully
        Command cmd2 = parser.parse("submit_assignment S01 Math101 HW1");
        invoker.executeCommand(cmd2);

        // Verify - duplicates not allowed
        assertEquals(1, student.getSubmittedAssignments().stream().filter(s -> s.equals("HW1")).count());
    }

    @Test
    void testOutOfBoxCaseInsensitiveCommands() {
        // Test if commands are case sensitive - assuming they are not
        Command cmd = parser.parse("SUBMIT_ASSIGNMENT S01 Math101 HW1");
        assertNull(cmd); // Assuming parser is case sensitive
    }

    @Test
    void testOutOfBoxEmptyClassroomRemoval() {
        // Setup
        manager.createClassroom("EmptyClass");

        // Execute
        Command cmd = parser.parse("remove_classroom EmptyClass");
        assertNotNull(cmd);
        invoker.executeCommand(cmd);
    }
}
