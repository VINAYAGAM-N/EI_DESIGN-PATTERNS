package com.ei.tests;
import com.ei.patterns.structural.filesystem_composite.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CompositeTest2 { @Test public void size(){ Folder f = new Folder("r"); f.add(new FileLeaf("a",100)); assertEquals(100, f.size()); } }
