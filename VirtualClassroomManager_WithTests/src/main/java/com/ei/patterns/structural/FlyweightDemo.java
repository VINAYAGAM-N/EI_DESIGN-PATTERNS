package com.ei.patterns.structural;

import com.ei.patterns.structural.flyweight.AssignmentTemplate;
import com.ei.patterns.structural.flyweight.AssignmentTemplateFactory;
import com.ei.patterns.structural.flyweight.AssignmentInstance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlyweightDemo {
    public static void main(String[] args) {
        List<AssignmentInstance> instances = new ArrayList<>();
        AssignmentTemplate t1 = AssignmentTemplateFactory.getTemplate("LAB_TEMPLATE_1");
        AssignmentTemplate t2 = AssignmentTemplateFactory.getTemplate("PROJECT_TEMPLATE_A");

        instances.add(new AssignmentInstance("Lab1", LocalDate.of(2025,9,20), t1));
        instances.add(new AssignmentInstance("Lab2", LocalDate.of(2025,9,27), t1));
        instances.add(new AssignmentInstance("Project1", LocalDate.of(2025,10,15), t2));

        System.out.println("Pool size: " + AssignmentTemplateFactory.poolSize());
        instances.forEach(System.out::println);

        AssignmentTemplate t1b = AssignmentTemplateFactory.getTemplate("LAB_TEMPLATE_1");
        System.out.println("t1 == t1b: " + (t1 == t1b));
    }
}
