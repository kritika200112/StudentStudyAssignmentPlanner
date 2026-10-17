
import java.util.ArrayList;
import java.util.List;

public class StudyPlanner {

    private final List<ProjectTask> tasks;

    public StudyPlanner() {
        tasks = new ArrayList<>();
    }

    public void addTask(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException(
                    "Task cannot be null.");
        }

        if (findTaskById(task.getAssignmentId()) != null) {
            throw new IllegalArgumentException(
                    "An assignment with this ID already exists.");
        }

        tasks.add(task);
    }

    public ProjectTask getTask(String assignmentId) {
        validateId(assignmentId);

        ProjectTask task = findTaskById(assignmentId);

        if (task == null) {
            throw new IllegalArgumentException(
                    "Assignment not found: " + assignmentId);
        }

        return task;
    }

    public boolean updateTask(String assignmentId, String newTitle,
                              String newCourse, String newDueDate,
                              int newPriority) {
        ProjectTask task = getTask(assignmentId);

        task.setTitle(newTitle);
        task.setCourse(newCourse);
        task.setDueDate(newDueDate);
        task.setPriority(newPriority);

        return true;
    }

    public boolean removeTask(String assignmentId) {
        validateId(assignmentId);

        ProjectTask task = findTaskById(assignmentId);

        if (task == null) {
            return false;
        }

        return tasks.remove(task);
    }

    public List<ProjectTask> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public int getCompletedTaskCount() {
        int count = 0;

        for (ProjectTask task : tasks) {
            if (task.isCompleted()) {
                count++;
            }
        }

        return count;
    }

    public int getIncompleteTaskCount() {
        return getTaskCount() - getCompletedTaskCount();
    }

    private ProjectTask findTaskById(String assignmentId) {
        for (ProjectTask task : tasks) {
            if (task.getAssignmentId().equals(assignmentId)) {
                return task;
            }
        }

        return null;
    }

    private void validateId(String assignmentId) {
        if (assignmentId == null || assignmentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Assignment ID cannot be empty.");
        }
    }
}
