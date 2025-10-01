package com.ei.tests;

import com.ei.patterns.structural.flyweight.AssignmentTemplate;
import com.ei.patterns.structural.flyweight.AssignmentTemplateFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlyweightTest {
    @Test
    public void testTemplateReuse() {
        AssignmentTemplate t1 = AssignmentTemplateFactory.getTemplate("LAB_TEMPLATE_1");
        AssignmentTemplate t2 = AssignmentTemplateFactory.getTemplate("LAB_TEMPLATE_1");
        assertSame(t1, t2);
        assertEquals(1, AssignmentTemplateFactory.poolSize());
    }
}
