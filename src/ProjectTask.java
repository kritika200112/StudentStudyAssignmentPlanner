public class ProjectTask {
    private String assignmentId;
    private String assignmentName;
    private String course;
    private String dueDate;
    private int priority;
    private boolean completed;

    public ProjectTask(String assignmentId, String assignmentName, String course,
                       String dueDate, int priority, boolean completed) {
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.course = course;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
    }

    public String getAssignmentId() {
        return assignmentId;
    }
}