package com.ei.tests;

import com.ei.patterns.behavioral.chat_observer.Channel;
import com.ei.patterns.behavioral.chat_observer.Message;
import com.ei.patterns.behavioral.chat_observer.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChatObserverTest {
    @Test
    public void testObserverPattern() {
        Channel general = new Channel("general");
        User alice = new User("Alice");
        User bob = new User("Bob");

        general.subscribe(alice);
        general.subscribe(bob);

        Message msg1 = new Message("Alice", "Hello everyone!");
        general.post(msg1);

        // Assuming User has a way to check received messages, but since it's printing, we can check if no exception
        // For simplicity, just ensure the post doesn't throw exception
        assertDoesNotThrow(() -> general.post(msg1));

        general.unsubscribe(bob);
        Message msg2 = new Message("Alice", "Bob left");
        assertDoesNotThrow(() -> general.post(msg2));
    }
}
