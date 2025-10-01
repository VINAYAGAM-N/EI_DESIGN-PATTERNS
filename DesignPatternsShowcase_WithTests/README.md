# DesignPatternsShowcase

Six small Java console applications demonstrating design patterns (behavioral, creational, structural).

Run all demos:
  cmd /c "cd DesignPatternsShowcase_WithTests & ..\\..\\apache-maven-3.9.4\\bin\\mvn.cmd exec:java -Dexec.mainClass=com.ei.Application"

Run individual demos with:
  cmd /c "cd DesignPatternsShowcase_WithTests & ..\\..\\apache-maven-3.9.4\\bin\\mvn.cmd exec:java -Dexec.mainClass="fully.qualified.DemoClassName""

Example:
  cmd /c "cd DesignPatternsShowcase_WithTests & ..\\..\\apache-maven-3.9.4\\bin\\mvn.cmd exec:java -Dexec.mainClass=com.ei.patterns.creational.travel_builder.TravelDemo"

Run tests:
  cmd /c "cd DesignPatternsShowcase_WithTests & ..\\..\\apache-maven-3.9.4\\bin\\mvn.cmd test"

Test Classes:
- TravelBuilderTest: Tests the Builder pattern for TravelPackage
- GameFactoryTest: Tests the Factory pattern for GameCharacter creation
- ChatObserverTest: Tests the Observer pattern for Channel subscriptions
- SmartHomeCommandTest: Tests the Command pattern for Light commands
- FileSystemCompositeTest: Tests the Composite pattern for file system structure
- GraphicsFlyweightTest: Tests the Flyweight pattern for Icon sharing
