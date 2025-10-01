package com.ei.manager;

import com.ei.model.Assignment;
import com.ei.model.Classroom;
import com.ei.model.Observer;
import com.ei.model.Student;

import java.util.*;
import java.util.logging.Logger;

public class ClassroomManager {
    private static final Logger LOGGER = Logger.getLogger(ClassroomManager.class.getName());
    private static ClassroomManager instance;
    private final Map<String, Classroom> classrooms;

    private ClassroomManager() {
        classrooms = new HashMap<>();
    }

    public static synchronized ClassroomManager getInstance() {
        if (instance == null) instance = new ClassroomManager();
        return instance;
    }

    public synchronized void createClassroom(String name) {
        if (classrooms.containsKey(name)) throw new IllegalArgumentException("Classroom already exists: " + name);
        classrooms.put(name, new Classroom(name));
        LOGGER.info("Created classroom " + name);
    }

    public synchronized Student getStudent(String classroomName, String studentId) {
        Classroom c = getClassroomOrThrow(classroomName);
        return c.getStudents().stream()
                .filter(o -> o instanceof Student)
                .map(o -> (Student) o)
                .filter(s -> s.getId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    public synchronized void enrollStudent(String classroomName, Student s) {
        Classroom c = getClassroomOrThrow(classroomName);
        c.register(s);
        LOGGER.info("Enrolled student " + s.getId() + " in " + classroomName);
    }

    public synchronized void scheduleAssignment(String classroomName, Assignment a) {
        Classroom c = getClassroomOrThrow(classroomName);
        c.addAssignment(a);
        LOGGER.info("Scheduled assignment " + a.getTitle() + " in " + classroomName);
    }

    public synchronized void submitAssignment(String studentId, String classroomName, String assignmentTitle) {
        Classroom c = getClassroomOrThrow(classroomName);
        boolean assignmentExists = c.getAssignments().stream().anyMatch(a -> a.getTitle().equals(assignmentTitle));
        if (!assignmentExists) throw new IllegalArgumentException("Assignment '" + assignmentTitle + "' not found in classroom " + classroomName);
        Student s = getStudent(studentId, classroomName);
        if (s == null) throw new IllegalArgumentException("Student " + studentId + " not found in classroom " + classroomName);
        s.submitAssignment(assignmentTitle);
        LOGGER.info("Student " + studentId + " submitted assignment " + assignmentTitle + " in " + classroomName);
    }

    public synchronized void removeClassroom(String name) {
        if (!classrooms.containsKey(name)) throw new NoSuchElementException("Classroom not found: " + name);
        Classroom c = classrooms.get(name);
        if (!c.getStudents().isEmpty()) throw new IllegalStateException("Cannot remove classroom with enrolled students: " + name);
        if (!c.getAssignments().isEmpty()) throw new IllegalStateException("Cannot remove classroom with scheduled assignments: " + name);
        classrooms.remove(name);
        LOGGER.info("Removed classroom " + name);
    }

    public synchronized void forceRemoveClassroom(String name) {
        if (!classrooms.containsKey(name)) throw new NoSuchElementException("Classroom not found: " + name);
        classrooms.remove(name);
        LOGGER.info("Force removed classroom " + name);
    }

    public synchronized Classroom getClassroom(String name) {
        return classrooms.get(name);
    }

    public synchronized List<String> listStudentsInClassroom(String classroomName) {
        Classroom c = getClassroomOrThrow(classroomName);
        List<String> students = new ArrayList<>();
        for (Observer o : c.getStudents()) {
            if (o instanceof Student) {
                Student s = (Student) o;
                students.add(s.getId() + " - " + s.getName());
            }
        }
        return students;
    }

    public synchronized void modifyAssignment(String classroomName, String assignmentTitle, java.time.LocalDate newDueDate) {
        Classroom c = getClassroomOrThrow(classroomName);
        Assignment a = c.getAssignments().stream().filter(as -> as.getTitle().equals(assignmentTitle)).findFirst().orElseThrow(() -> new NoSuchElementException("Assignment not found: " + assignmentTitle));
        a.setDueDate(newDueDate);
        LOGGER.info("Modified assignment " + assignmentTitle + " in " + classroomName + " to due " + newDueDate);
    }

    public synchronized List<String> listClassrooms() {
        List<String> out = new ArrayList<>();
        for (Classroom c : classrooms.values()) out.add(c.toString());
        return out;
    }

    // For testing purposes
    public synchronized void clearClassrooms() {
        classrooms.clear();
    }

    private Classroom getClassroomOrThrow(String name) {
        Classroom c = classrooms.get(name);
        if (c == null) throw new NoSuchElementException("Classroom not found: " + name);
        return c;
    }
}
