# Virtual Classroom Manager - Java (Full)

This project demonstrates the implementation of multiple design patterns in a Java-based Virtual Classroom Manager application. It integrates behavioral, creational, and structural design patterns to provide a robust and extensible system for managing classrooms, students, and assignments via a command-line interface (CLI).

## Design Patterns Implemented

- **Behavioral Patterns:**
  - **Observer:** Assignment notifications to enrolled students.
  - **Command:** CLI commands for managing classrooms, students, and assignments.

- **Creational Patterns:**
  - **Factory:** EntityFactory for creating domain entities.
  - **Builder:** AssignmentWithBuilder for flexible assignment creation.

- **Structural Patterns:**
  - **Composite:** Course, Module, Lesson hierarchy for content management.
  - **Flyweight:** Assignment templates to optimize memory usage.

## Features

- Create and remove classrooms with validation to prevent data loss.
- Enroll students in classrooms.
- Schedule assignments with due dates.
- Submit assignments with validation and auto-confirmation for:
  - Duplicate submissions.
  - Past due date submissions.
  - Multiple assignment submissions per student.
- List classrooms and students.
- Modify assignment due dates.
- Non-interactive execution with predefined commands.
- Comprehensive logging for key operations.

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6 or higher

## Build Instructions

Clone the repository and navigate to the project directory.

```bash
mvn clean package
```

This will compile the source code and package the application.

## Running the Application

Run the application using Maven:

```bash
mvn exec:java -Dexec.mainClass="com.ei.app.Main"
```

Or from the combined repository root:

```bash
cd VirtualClassroomManager_WithTests
..\apache-maven-3.9.4\bin\mvn.cmd exec:java -Dexec.mainClass=com.ei.app.Main
```

The application will execute a predefined sequence of commands automatically, demonstrating the Command and Observer patterns without user interaction.

## Predefined Commands Executed

The application executes the following sequence of commands automatically:

- `add_classroom Math101`: Create a new classroom.
- `add_classroom Science202`: Create another classroom.
- `add_student 1 Math101 Alice`: Enroll a student.
- `add_student 2 Math101 Bob`: Enroll another student.
- `add_student 3 Science202 Charlie`: Enroll a student in another classroom.
- `schedule_assignment Math101 Homework1 2023-12-01`: Schedule an assignment.
- `schedule_assignment Science202 LabReport 2023-12-05`: Schedule another assignment.
- `submit_assignment 1 Math101 Homework1`: Submit an assignment (auto-confirmed).
- `submit_assignment 2 Math101 Homework1`: Submit another assignment (auto-confirmed).
- `list_classrooms`: List all classrooms.
- `list_students Math101`: List students in a classroom.
- `list_students Science202`: List students in another classroom.
- `modify_assignment Math101 Homework1 2023-12-03`: Modify assignment due date.
- `remove_classroom Science202`: Remove a classroom (auto-confirmed force removal).



## Testing

The project includes comprehensive JUnit 5 tests covering all commands, edge cases, and auto-confirmed scenarios.

Run tests with:

```bash
mvn test
```

Or from the combined repository root:

```bash
cd VirtualClassroomManager_WithTests
..\apache-maven-3.9.4\bin\mvn.cmd test
```

All tests pass successfully, ensuring reliability.

## Logging

Key operations are logged using Java's built-in logging framework for audit and debugging purposes.

## Project Structure

```
src/
├── main/java/com/ei/
│   ├── app/Main.java                    # CLI entry point
│   ├── manager/ClassroomManager.java    # Core business logic
│   ├── model/                           # Domain models
│   │   ├── Assignment.java
│   │   ├── Classroom.java
│   │   └── Student.java
│   └── patterns/                        # Design pattern implementations
│       ├── command/                     # Command pattern
│       ├── creational/                  # Factory and Builder
│       └── structural/                  # Composite and Flyweight
└── test/java/com/ei/tests/               # Unit tests
```

## Contribution

Contributions are welcome. Please fork the repository and submit pull requests for improvements or bug fixes.

## License

This project is licensed under the MIT License.

---

This README provides a complete overview of the Virtual Classroom Manager project, its design, usage, and testing to facilitate easy understanding and contribution.
