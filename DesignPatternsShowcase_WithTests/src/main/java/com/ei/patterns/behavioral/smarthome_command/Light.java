package com.ei.patterns.behavioral.smarthome_command;
public class Light {
    private boolean on;
    private final String id;
    public Light(String id){ this.id = id; }
    public void on(){ on = true; System.out.println(id+" light is ON"); }
    public void off(){ on = false; System.out.println(id+" light is OFF"); }
    public boolean isOn(){ return on; }
}
