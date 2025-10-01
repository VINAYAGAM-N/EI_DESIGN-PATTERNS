package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class ModifyAssignmentCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(ModifyAssignmentCommand.class.getName());
    private final ClassroomManager manager;
    private final String classroomName;
    private final String assignmentTitle;
    private final LocalDate newDueDate;

    public ModifyAssignmentCommand(ClassroomManager manager, String classroomName, String assignmentTitle, LocalDate newDueDate) {
        this.manager = manager;
        this.classroomName = classroomName;
        this.assignmentTitle = assignmentTitle;
        this.newDueDate = newDueDate;
    }

    @Override
    public void execute() {
        try {
            manager.modifyAssignment(classroomName, assignmentTitle, newDueDate);
            System.out.println("Assignment " + assignmentTitle + " in " + classroomName + " modified to due " + newDueDate);
            LOGGER.info("Modified assignment " + assignmentTitle + " in " + classroomName);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
