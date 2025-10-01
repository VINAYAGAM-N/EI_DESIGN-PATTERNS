package com.ei.patterns.behavioral.smarthome_command;
import java.util.Stack;
public class RemoteControl {
    private final Stack<Command> history = new Stack<>();
    public void submit(Command c){ c.execute(); history.push(c); }
    public void undo(){ if(!history.isEmpty()){ Command c = history.pop(); c.undo(); } else System.out.println("Nothing to undo"); }
}
