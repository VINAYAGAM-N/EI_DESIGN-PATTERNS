package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;
import com.ei.model.Assignment;
import com.ei.model.Student;

import java.time.LocalDate;

public class CommandParser {
    private final ClassroomManager manager = ClassroomManager.getInstance();

    public Command parse(String input) {
        String[] parts = input.split("\\s+", 4);
        if (parts.length == 0) return null;
        String keyword = parts[0];
        switch (keyword) {
            case "add_classroom" :
                if (parts.length < 2) return null;
                return new AddClassroomCommand(manager, parts[1]);
            case "add_student" :
                if (parts.length < 4) return null;
                return new AddStudentCommand(manager, new Student(parts[1], parts[3]), parts[2]);
            case "schedule_assignment" :
                if (parts.length < 4) return null;
                LocalDate due = LocalDate.parse(parts[3]);
                Assignment a = new Assignment(parts[2], due);
                return new ScheduleAssignmentCommand(manager, parts[1], a);
            case "list_classrooms" :
                return new ListClassroomsCommand(manager);
            case "submit_assignment" :
                if (parts.length < 4) return null;
                return new SubmitAssignmentCommand(manager, parts[1], parts[2], parts[3]);
            case "remove_classroom" :
                if (parts.length < 2) return null;
                return new RemoveClassroomCommand(manager, parts[1]);
            case "list_students" :
                if (parts.length < 2) return null;
                return new ListStudentsCommand(manager, parts[1]);
            case "modify_assignment" :
                if (parts.length < 4) return null;
                java.time.LocalDate newDueDate = java.time.LocalDate.parse(parts[3]);
                return new ModifyAssignmentCommand(manager, parts[1], parts[2], newDueDate);
            default:
                return null;
        }
    }
}
