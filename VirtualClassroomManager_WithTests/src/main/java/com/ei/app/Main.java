package com.ei.app;

import com.ei.patterns.command.Command;
import com.ei.patterns.command.CommandInvoker;
import com.ei.patterns.command.CommandParser;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        CommandInvoker invoker = new CommandInvoker();
        CommandParser parser = new CommandParser();

        System.out.println("Virtual Classroom Manager - Full Demo (Command + Observer integrated)");
        System.out.println("Executing predefined commands...");

        // List of predefined commands to execute
        List<String> commands = Arrays.asList(
            "add_classroom Math101",
            "add_classroom Science202",
            "add_student 1 Math101 Alice",
            "add_student 2 Math101 Bob",
            "add_student 3 Science202 Charlie",
            "schedule_assignment Math101 Homework1 2023-12-01",
            "schedule_assignment Science202 LabReport 2023-12-05",
            "submit_assignment 1 Math101 Homework1",
            "submit_assignment 2 Math101 Homework1",
            "list_classrooms",
            "list_students Math101",
            "list_students Science202",
            "modify_assignment Math101 Homework1 2023-12-03",
            "remove_classroom Science202"
        );

        for (String line : commands) {
            System.out.println("> " + line);
            try {
                Command cmd = parser.parse(line);
                if (cmd != null) {
                    invoker.executeCommand(cmd);
                } else {
                    System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                LOGGER.severe("Error: " + e.getMessage());
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        System.out.println("All commands executed. Exiting.");
    }
}
