package com.ei.patterns.behavioral.chat_observer;
public class User implements ChannelObserver {
    private final String name;
    public User(String name){ this.name = name; }
    @Override public void onMessage(Message m, Channel c){ System.out.println("["+name+"] New on " + c.getName() + ": " + m); }
    public String getName(){ return name; }
}
