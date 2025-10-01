package com.ei.patterns.behavioral.smarthome_command;
public class SmartHomeDemo {
    public static void main(String[] args) {
        Light living = new Light("LivingRoom");
        RemoteControl remote = new RemoteControl();
        remote.submit(new LightOnCommand(living));
        remote.submit(new LightOffCommand(living));
        remote.undo(); // should turn on
        remote.undo(); // should turn off (or nothing)
    }
}
