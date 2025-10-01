package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;

public class ListClassroomsCommand implements Command {
    private final ClassroomManager manager;

    public ListClassroomsCommand(ClassroomManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.listClassrooms().forEach(System.out::println);
    }
}
