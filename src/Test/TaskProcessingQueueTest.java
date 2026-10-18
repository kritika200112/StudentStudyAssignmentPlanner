import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskProcessingQueueTest {

    private ProjectTask createTask(String id, String title) {
        return new ProjectTask(
                id, title, "CSC 223",
                "2026-10-25", 1, false);
    }

    @Test
    public void newQueueIsEmpty() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void addOneTask() {
        TaskProcessingQueue queue = new TaskProcessingQueue();
        ProjectTask task = createTask("A101", "Math Homework");

        queue.addTask(task);

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void addMultipleTasks() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        queue.addTask(createTask("A101", "Math"));
        queue.addTask(createTask("A102", "Java"));
        queue.addTask(createTask("A103", "Geology"));

        assertEquals(3, queue.size());
    }

    @Test
    public void peekReturnsFirstTaskWithoutRemovingIt() {
        TaskProcessingQueue queue = new TaskProcessingQueue();
        ProjectTask first = createTask("A101", "Math");

        queue.addTask(first);
        queue.addTask(createTask("A102", "Java"));

        assertSame(first, queue.peekNextTask());
        assertEquals(2, queue.size());
    }

    @Test
    public void tasksAreProcessedInFifoOrder() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        ProjectTask first = createTask("A101", "Math");
        ProjectTask second = createTask("A102", "Java");
        ProjectTask third = createTask("A103", "Geology");
        ProjectTask fourth = createTask("A104", "English");

        queue.addTask(first);
        queue.addTask(second);
        queue.addTask(third);
        queue.addTask(fourth);

        assertSame(first, queue.processNextTask());
        assertSame(second, queue.processNextTask());
        assertSame(third, queue.processNextTask());
        assertSame(fourth, queue.processNextTask());

        assertTrue(queue.isEmpty());
    }

    @Test
    public void processingMarksTaskCompleted() {
        TaskProcessingQueue queue = new TaskProcessingQueue();
        ProjectTask task = createTask("A101", "Math");

        queue.addTask(task);
        ProjectTask processed = queue.processNextTask();

        assertSame(task, processed);
        assertTrue(task.isCompleted());
    }

    @Test
    public void processingUpdatesQueueSize() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        queue.addTask(createTask("A101", "Math"));
        queue.addTask(createTask("A102", "Java"));

        queue.processNextTask();

        assertEquals(1, queue.size());
    }

    @Test
    public void processingLastTaskMakesQueueEmpty() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        queue.addTask(createTask("A101", "Math"));
        queue.processNextTask();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void processingEmptyQueueThrowsException() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        assertThrows(
                NoSuchElementException.class,
                queue::processNextTask);
    }

    @Test
    public void peekingAtEmptyQueueThrowsException() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        assertThrows(
                NoSuchElementException.class,
                queue::peekNextTask);
    }

    @Test
    public void nullTaskIsRejected() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        assertThrows(
                IllegalArgumentException.class,
                () -> queue.addTask(null));
    }

    @Test
    public void completedTaskIsRejected() {
        TaskProcessingQueue queue = new TaskProcessingQueue();
        ProjectTask task = createTask("A101", "Math");
        task.markCompleted();

        assertThrows(
                IllegalArgumentException.class,
                () -> queue.addTask(task));
    }

    @Test
    public void duplicateTaskIdIsRejected() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        queue.addTask(createTask("A101", "Math"));

        assertThrows(
                IllegalArgumentException.class,
                () -> queue.addTask(
                        createTask("A101", "Another Math Task")));
    }

    @Test
    public void waitingTasksAreReturnedInQueueOrder() {
        TaskProcessingQueue queue = new TaskProcessingQueue();

        ProjectTask first = createTask("A101", "Math");
        ProjectTask second = createTask("A102", "Java");

        queue.addTask(first);
        queue.addTask(second);

        List<ProjectTask> waiting = queue.getWaitingTasks();

        assertEquals(2, waiting.size());
        assertSame(first, waiting.get(0));
        assertSame(second, waiting.get(1));
    }

    @Test
    public void clearRemovesTasksWithoutCompletingThem() {
        TaskProcessingQueue queue = new TaskProcessingQueue();
        ProjectTask task = createTask("A101", "Math");

        queue.addTask(task);
        queue.clear();

        assertTrue(queue.isEmpty());
        assertFalse(task.isCompleted());
    }
}

