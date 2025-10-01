package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;
import com.ei.model.Assignment;

public class ScheduleAssignmentCommand implements Command {
    private final ClassroomManager manager;
    private final String classroomName;
    private final Assignment assignment;

    public ScheduleAssignmentCommand(ClassroomManager manager, String classroomName, Assignment assignment) {
        this.manager = manager;
        this.classroomName = classroomName;
        this.assignment = assignment;
    }

    @Override
    public void execute() {
        manager.scheduleAssignment(classroomName, assignment);
        System.out.println("Scheduled assignment '" + assignment.getTitle() + "' for " + classroomName);
    }
}
