package com.ei.patterns.structural.flyweight;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class AssignmentTemplateFactory {
    private static final Map<String, AssignmentTemplate> POOL = new ConcurrentHashMap<>();

    public static AssignmentTemplate getTemplate(String templateId) {
        return POOL.computeIfAbsent(templateId, id -> {
            String content = ("This is the content of template '" + id + "'.\n") + ("[Lots of instructions...]".repeat(20));
            String rubric = "Rubric for " + id + ": High quality, meets requirements";
            return new AssignmentTemplate(id, content, rubric);
        });
    }

    public static int poolSize() { return POOL.size(); }
}
