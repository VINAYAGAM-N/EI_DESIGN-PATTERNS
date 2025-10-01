package com.ei.patterns.structural.flyweight;

public final class AssignmentTemplate {
    private final String templateId;
    private final String content; // potentially large
    private final String rubric; // potentially large

    public AssignmentTemplate(String templateId, String content, String rubric) {
        this.templateId = templateId;
        this.content = content;
        this.rubric = rubric;
    }

    public String getTemplateId() { return templateId; }
    public String getContent() { return content; }
    public String getRubric() { return rubric; }

    @Override
    public String toString() {
        return "Template[" + templateId + "] (content len=" + (content == null ? 0 : content.length()) + ")";
    }
}
