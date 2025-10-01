package com.ei.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Student implements Observer {
    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());
    private final String id;
    private final String name;
    private boolean subscribed = true;
    private final List<String> submittedAssignments = new ArrayList<>();

    public Student(String id, String name) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Student id required");
        this.id = id;
        this.name = name == null ? "" : name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public List<String> getSubmittedAssignments() { return submittedAssignments; }

    public void submitAssignment(String title) {
        if (!submittedAssignments.contains(title)) {
            submittedAssignments.add(title);
        }
    }

    @Override
    public void update(Assignment a, String classroomName) {
        String msg = String.format("Notification to %s [%s]: New assignment '%s' in %s due %s", name, id, a.getTitle(), classroomName, a.getDueDate());
        System.out.println(msg);
        LOGGER.info("Notified student " + id + " about assignment " + a.getTitle());
    }

    public boolean isSubscribed() { return subscribed; }
    public void setSubscribed(boolean val) { this.subscribed = val; }
}
