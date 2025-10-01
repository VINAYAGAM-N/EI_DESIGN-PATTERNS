package com.ei.tests;

import com.ei.patterns.behavioral.smarthome_command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartHomeCommandTest {
    private RemoteControl remote;
    private Light light;

    @BeforeEach
    public void setup() {
        remote = new RemoteControl();
        light = new Light("LivingRoom");
    }

    @Test
    public void testLightOnOffCommands() {
        LightOnCommand lightOn = new LightOnCommand(light);
        LightOffCommand lightOff = new LightOffCommand(light);

        remote.submit(lightOn);
        assertTrue(light.isOn());

        remote.submit(lightOff);
        assertFalse(light.isOn());
    }
}
