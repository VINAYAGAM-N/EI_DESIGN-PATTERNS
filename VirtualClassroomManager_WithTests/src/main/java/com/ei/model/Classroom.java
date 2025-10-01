package com.ei.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Classroom implements Subject {
    private final String name;
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final List<Assignment> assignments = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    @Override
    public void register(Observer o) {
        if (!observers.contains(o)) observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAll(Assignment a) {
        for (Observer o : observers) {
            if (o instanceof Student) {
                Student s = (Student)o;
                if (!s.isSubscribed()) continue;
            }
            o.update(a, name);
        }
    }

    public void addAssignment(Assignment a) {
        assignments.add(a);
        notifyAll(a);
    }

    public String getName() { return name; }

    public List<Observer> getStudents() { return observers; }

    public List<Assignment> getAssignments() { return assignments; }

    @Override
    public String toString() {
        return "Classroom{" + name + ", students=" + observers.size() + ", assignments=" + assignments.size() + "}";
    }
}
