package com.ei.patterns.behavioral.chat_observer;
public class ChatDemo {
    public static void main(String[] args) throws Exception {
        Channel general = new Channel("general");
        User alice = new User("Alice");
        User bob = new User("Bob");
        general.subscribe(alice);
        general.subscribe(bob);
        general.post(new Message("Alice", "Hello everyone!"));
        general.unsubscribe(bob);
        general.post(new Message("Alice", "Bob left, only Alice sees this."));
    }
}
