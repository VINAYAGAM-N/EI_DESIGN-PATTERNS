package com.ei.patterns.command;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CommandInvoker {
    private static final Logger LOGGER = Logger.getLogger(CommandInvoker.class.getName());
    private final List<Command> history = new ArrayList<>();

    public void executeCommand(Command cmd) {
        LOGGER.info("Executing: " + cmd.getClass().getSimpleName());
        cmd.execute();
        history.add(cmd);
    }

    public List<Command> getHistory() {
        return history;
    }
}
