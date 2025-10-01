# Design Patterns and Virtual Classroom Manager

This repository combines two Java projects demonstrating design patterns and their application in a real-world scenario.

## Projects

### 1. DesignPatternsShowcase_WithTests
A collection of small Java console applications showcasing six design patterns:
- **Creational**: Builder (TravelPackage), Factory (GameCharacter)
- **Behavioral**: Observer (Chat Channel), Command (Smart Home)
- **Structural**: Composite (File System), Flyweight (Graphics Icons)

**Features**:
- Individual demos for each pattern
- Comprehensive JUnit 5 test suite (9 tests)
- Maven-based build

**Run all demos**:
```
cd DesignPatternsShowcase_WithTests
..\apache-maven-3.9.4\bin\mvn.cmd exec:java -Dexec.mainClass=com.ei.Application
```

**Run tests**:
```
cd DesignPatternsShowcase_WithTests
..\apache-maven-3.9.4\bin\mvn.cmd test
```

### 2. VirtualClassroomManager_WithTests
A full-featured virtual classroom management system implementing multiple design patterns:
- **Behavioral**: Observer (assignment notifications), Command (CLI operations)
- **Creational**: Factory (entity creation), Builder (assignment building)
- **Structural**: Composite (course content hierarchy), Flyweight (assignment templates)

**Features**:
- Command-line interface for classroom management
- Student enrollment and assignment handling
- Auto-confirmation for edge cases (duplicate submissions, force removals)
- Comprehensive JUnit 5 test suite (19 tests)
- Logging for audit trails

**Run application**:
```
cd VirtualClassroomManager_WithTests
..\apache-maven-3.9.4\bin\mvn.cmd exec:java -Dexec.mainClass=com.ei.app.Main
```

**Run tests**:
```
cd VirtualClassroomManager_WithTests
..\apache-maven-3.9.4\bin\mvn.cmd test
```

## Prerequisites
- JDK 17+
- Apache Maven 3.6+

## Testing Results
- DesignPatternsShowcase_WithTests: 9/9 tests passing
- VirtualClassroomManager_WithTests: 19/19 tests passing

## Project Structure
```
DesignPatternsAndVirtualClassroom/
├── DesignPatternsShowcase_WithTests/     # Pattern demos with tests
└── VirtualClassroomManager_WithTests/    # Full application with tests
```

Each subproject is self-contained with its own Maven configuration and can be built/run independently.
