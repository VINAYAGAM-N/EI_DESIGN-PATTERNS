package com.ei.tests;

import com.ei.patterns.structural.content.Course;
import com.ei.patterns.structural.content.Module;
import com.ei.patterns.structural.content.Lesson;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompositeTest {
    @Test
    public void testCourseDuration() {
        Course c = new Course("Algorithms");
        Module m = new Module("Sorting");
        m.add(new Lesson("QuickSort", 30));
        m.add(new Lesson("MergeSort", 40));
        c.add(m);
        assertEquals(70, c.getDurationMinutes());
    }
}
