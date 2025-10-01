package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;

import java.util.List;
import java.util.logging.Logger;

public class ListStudentsCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(ListStudentsCommand.class.getName());
    private final ClassroomManager manager;
    private final String classroomName;

    public ListStudentsCommand(ClassroomManager manager, String classroomName) {
        this.manager = manager;
        this.classroomName = classroomName;
    }

    @Override
    public void execute() {
        try {
            List<String> students = manager.listStudentsInClassroom(classroomName);
            if (students.isEmpty()) {
                System.out.println("No students found in classroom " + classroomName);
            } else {
                System.out.println("Students in classroom " + classroomName + ":");
                for (String s : students) {
                    System.out.println(" - " + s);
                }
            }
            LOGGER.info("Listed students in classroom " + classroomName);
        } catch (Exception e) {
            System.out.println("Error listing students: " + e.getMessage());
        }
    }
}
