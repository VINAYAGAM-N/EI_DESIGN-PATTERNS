package com.ei.patterns.behavioral.chat_observer;
public class Message {
    private final String from;
    private final String text;
    public Message(String from, String text){ this.from = from; this.text = text; }
    public String getFrom(){ return from; }
    public String getText(){ return text; }
    @Override public String toString(){ return from + ": " + text; }
}
