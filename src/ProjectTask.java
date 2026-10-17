
import java.util.Objects;

public class ProjectTask {

    private final String assignmentId;
    private String title;
    private String course;
    private String dueDate;
    private int priority;
    private boolean completed;

    public ProjectTask(String assignmentId, String title, String course,
                       String dueDate, int priority, boolean completed) {

        if (assignmentId == null || assignmentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Assignment ID cannot be empty.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Title cannot be empty.");
        }

        if (course == null || course.isBlank()) {
            throw new IllegalArgumentException(
                    "Course cannot be empty.");
        }

        if (dueDate == null || dueDate.isBlank()) {
            throw new IllegalArgumentException(
                    "Due date cannot be empty.");
        }

        if (priority < 1 || priority > 3) {
            throw new IllegalArgumentException(
                    "Priority must be between 1 and 3.");
        }

        this.assignmentId = assignmentId;
        this.title = title;
        this.course = course;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getCourse() {
        return course;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Title cannot be empty.");
        }
        this.title = title;
    }

    public void setCourse(String course) {
        if (course == null || course.isBlank()) {
            throw new IllegalArgumentException(
                    "Course cannot be empty.");
        }
        this.course = course;
    }

    public void setDueDate(String dueDate) {
        if (dueDate == null || dueDate.isBlank()) {
            throw new IllegalArgumentException(
                    "Due date cannot be empty.");
        }
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        if (priority < 1 || priority > 3) {
            throw new IllegalArgumentException(
                    "Priority must be between 1 and 3.");
        }
        this.priority = priority;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean markCompleted() {
        if (completed) {
            return false;
        }
        completed = true;
        return true;
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "assignmentId='" + assignmentId + '\'' +
                ", title='" + title + '\'' +
                ", course='" + course + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", priority=" + priority +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProjectTask)) {
            return false;
        }
        ProjectTask other = (ProjectTask) obj;
        return assignmentId.equals(other.assignmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentId);
    }
}
