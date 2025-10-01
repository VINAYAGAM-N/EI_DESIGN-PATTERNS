package com.ei.tests;

import com.ei.patterns.command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {
    private CommandInvoker invoker;
    private CommandParser parser;

    @BeforeEach
    public void setup() {
        invoker = new CommandInvoker();
        parser = new CommandParser();
    }

    @Test
    public void testAddClassroomCommand() {
        Command cmd = parser.parse("add_classroom TestClass");
        assertNotNull(cmd);
        invoker.executeCommand(cmd);
        assertFalse(invoker.getHistory().isEmpty());
    }
}
