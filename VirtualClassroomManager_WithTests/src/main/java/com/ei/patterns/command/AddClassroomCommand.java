package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;

public class AddClassroomCommand implements Command {
    private final ClassroomManager manager;
    private final String name;

    public AddClassroomCommand(ClassroomManager manager, String name) {
        this.manager = manager;
        this.name = name;
    }

    @Override
    public void execute() {
        manager.createClassroom(name);
        System.out.println("Classroom " + name + " created.");
    }
}
