import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Processes incomplete assignments in first-in, first-out order.
 */
public class TaskProcessingQueue {

    private final Deque<ProjectTask> tasks;

    public TaskProcessingQueue() {
        tasks = new ArrayDeque<>();
    }

    /**
     * Adds an incomplete assignment to the rear of the queue.
     */
    public void addTask(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException(
                    "Task cannot be null.");
        }

        if (task.isCompleted()) {
            throw new IllegalArgumentException(
                    "Completed tasks cannot enter the queue.");
        }

        if (containsTask(task.getAssignmentId())) {
            throw new IllegalArgumentException(
                    "Task is already in the queue.");
        }

        tasks.addLast(task);
    }

    /**
     * Returns the next assignment without removing it.
     */
    public ProjectTask peekNextTask() {
        if (tasks.isEmpty()) {
            throw new NoSuchElementException(
                    "There are no tasks waiting to be processed.");
        }

        return tasks.getFirst();
    }

    /**
     * Processes the oldest assignment and marks it completed.
     */
    public ProjectTask processNextTask() {
        if (tasks.isEmpty()) {
            throw new NoSuchElementException(
                    "There are no tasks waiting to be processed.");
        }

        ProjectTask task = tasks.removeFirst();
        task.markCompleted();

        return task;
    }

    public int size() {
        return tasks.size();
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Returns a copy of the queue in processing order.
     */
    public List<ProjectTask> getWaitingTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Removes all waiting tasks without marking them completed.
     */
    public void clear() {
        tasks.clear();
    }

    private boolean containsTask(String assignmentId) {
        for (ProjectTask task : tasks) {
            if (task.getAssignmentId().equals(assignmentId)) {
                return true;
            }
        }

        return false;
    }
}
