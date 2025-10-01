package com.ei.model;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyAll(Assignment a);
}
