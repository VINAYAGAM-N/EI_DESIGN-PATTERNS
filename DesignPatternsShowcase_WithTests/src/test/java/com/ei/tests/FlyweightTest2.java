package com.ei.tests;
import com.ei.patterns.structural.graphics_flyweight.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FlyweightTest2 { @Test public void pool(){ Icon a = IconFactory.getIcon("sm"); Icon b = IconFactory.getIcon("sm"); assertSame(a,b); assertEquals(1, IconFactory.poolSize()); } }
