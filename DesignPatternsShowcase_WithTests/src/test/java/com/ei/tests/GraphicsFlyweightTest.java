package com.ei.tests;

import com.ei.patterns.structural.graphics_flyweight.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphicsFlyweightTest {
    @Test
    public void testFlyweightPattern() {
        Canvas c = new Canvas();
        c.place("smile");
        c.place("smile");
        c.place("heart");
        // Same icon should be reused
        assertEquals(2, IconFactory.poolSize());
        Icon smile1 = IconFactory.getIcon("smile");
        Icon smile2 = IconFactory.getIcon("smile");
        assertSame(smile1, smile2);
    }
}
