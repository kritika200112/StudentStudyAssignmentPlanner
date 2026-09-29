import java.util.List;

public class SequenceSearch {

    /**
     * Searches for a project task by its assignment ID.
     *
     * @param tasks the list of project tasks to search
     * @param targetId the assignment ID to find
     * @return the matching ProjectTask, or null if no match is found
     */
    public static ProjectTask findByAssignmentId(List<ProjectTask> tasks, String targetId) {
        if (tasks == null) {
            throw new IllegalArgumentException("Task list cannot be null.");
        }

        if (targetId == null || targetId.isBlank()) {
            throw new IllegalArgumentException("Assignment ID cannot be empty.");
        }

        for (ProjectTask task : tasks) {
            if (task != null && task.getAssignmentId().equals(targetId)) {
                return task;
            }
        }

        return null;
    }
}