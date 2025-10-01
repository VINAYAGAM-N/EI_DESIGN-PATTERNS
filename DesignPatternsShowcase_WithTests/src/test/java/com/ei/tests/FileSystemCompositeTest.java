package com.ei.tests;

import com.ei.patterns.structural.filesystem_composite.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemCompositeTest {
    @Test
    public void testFileSystemComposite() {
        Folder root = new Folder("root");
        Folder docs = new Folder("docs");
        docs.add(new FileLeaf("a.txt", 1200));
        docs.add(new FileLeaf("b.pdf", 50000));
        Folder pics = new Folder("pics");
        pics.add(new FileLeaf("img1.jpg", 200000));
        pics.add(new FileLeaf("img2.png", 150000));
        root.add(docs);
        root.add(pics);
        assertEquals(1200 + 50000 + 200000 + 150000, root.size());
        assertEquals("root", root.getName());
    }
}
