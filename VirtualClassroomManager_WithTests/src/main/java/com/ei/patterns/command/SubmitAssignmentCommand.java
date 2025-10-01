package com.ei.patterns.command;

import com.ei.manager.ClassroomManager;
import com.ei.model.Student;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class SubmitAssignmentCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(SubmitAssignmentCommand.class.getName());
    private final ClassroomManager manager;
    private final String studentId;
    private final String classroomName;
    private final String assignmentTitle;

    public SubmitAssignmentCommand(ClassroomManager manager, String studentId, String classroomName, String assignmentTitle) {
        this.manager = manager;
        this.studentId = studentId;
        this.classroomName = classroomName;
        this.assignmentTitle = assignmentTitle;
    }

    @Override
    public void execute() {
        try {
            Student student = manager.getStudent(classroomName, studentId);
            if (student == null) {
                System.out.println("Student " + studentId + " not found in classroom " + classroomName);
                return;
            }
            if (student.getSubmittedAssignments().contains(assignmentTitle)) {
                System.out.println("Warning: Assignment '" + assignmentTitle + "' already submitted by Student " + studentId);
                System.out.println("Proceeding with submission (auto-confirmed).");
            }
            // Check time limit exceeded
            com.ei.model.Classroom classroom = manager.getClassroom(classroomName);
            if (classroom == null) throw new NoSuchElementException("Classroom not found: " + classroomName);
            com.ei.model.Assignment assignment = classroom.getAssignments().stream()
                    .filter(a -> a.getTitle().equals(assignmentTitle))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Assignment not found: " + assignmentTitle));
            if (assignment.getDueDate().isBefore(java.time.LocalDate.now())) {
                System.out.println("Warning: Assignment '" + assignmentTitle + "' is past due date.");
                System.out.println("Proceeding with submission (auto-confirmed).");
            }
            // Check if more than one assignment submitted (assuming only one allowed)
            if (student.getSubmittedAssignments().size() >= 1 && !student.getSubmittedAssignments().contains(assignmentTitle)) {
                System.out.println("Warning: Student " + studentId + " has already submitted another assignment. Only one submission allowed.");
                System.out.println("Proceeding with submission (auto-confirmed).");
            }
            student.submitAssignment(assignmentTitle);
            System.out.println("Assignment submitted by Student " + studentId + " in " + classroomName);
            LOGGER.info("Student " + studentId + " submitted assignment " + assignmentTitle + " in " + classroomName);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
