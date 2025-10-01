package com.ei.tests;

import com.ei.patterns.creational.AssignmentWithBuilder;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {
    @Test
    public void testBuilderCreatesAssignment() {
        AssignmentWithBuilder a = new AssignmentWithBuilder.Builder()
                .setTitle("Proj1")
                .setDueDate(LocalDate.now().plusDays(10))
                .setDescription("Big project")
                .setAttachments(Arrays.asList("a.pdf", "b.pdf"))
                .setAllowedLateDays(1)
                .build();
        assertEquals("Proj1", a.getTitle());
        assertEquals(1, a.getAllowedLateDays());
    }
}
