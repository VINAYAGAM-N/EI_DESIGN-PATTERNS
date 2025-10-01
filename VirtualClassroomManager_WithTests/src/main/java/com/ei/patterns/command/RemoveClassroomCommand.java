package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;

import java.util.IllegalFormatException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

public class RemoveClassroomCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(RemoveClassroomCommand.class.getName());
    private final ClassroomManager manager;
    private final String classroomName;

    public RemoveClassroomCommand(ClassroomManager manager, String classroomName) {
        this.manager = manager;
        this.classroomName = classroomName;
    }

    @Override
    public void execute() {
        try {
            manager.removeClassroom(classroomName);
            System.out.println("Classroom " + classroomName + " has been removed.");
            LOGGER.info("Removed classroom " + classroomName);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Proceeding with force removal (auto-confirmed).");
            manager.forceRemoveClassroom(classroomName);
            System.out.println("Classroom " + classroomName + " has been force removed.");
            LOGGER.info("Force removed classroom " + classroomName);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
