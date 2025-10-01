package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;
import com.ei.model.Student;

public class AddStudentCommand implements Command {
    private final ClassroomManager manager;
    private final Student student;
    private final String classroomName;

    public AddStudentCommand(ClassroomManager manager, Student student, String classroomName) {
        this.manager = manager;
        this.student = student;
        this.classroomName = classroomName;
    }

    @Override
    public void execute() {
        manager.enrollStudent(classroomName, student);
        System.out.println("Enrolled student " + student.getId() + " in " + classroomName);
    }
}
