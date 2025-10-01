package com.ei.patterns.creational.game_factory;
public abstract class GameCharacter {
    protected final String name;
    protected final int hp;
    protected GameCharacter(String name, int hp){ this.name = name; this.hp = hp; }
    public abstract String role();
    public String getName() { return name; }
    public String getType() { return role(); }
    @Override public String toString(){ return name + " (" + role() + ", hp=" + hp + ")"; }
}
