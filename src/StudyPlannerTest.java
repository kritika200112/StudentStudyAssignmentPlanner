
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyPlannerTest {

    private ProjectTask makeTask(String id, String title) {
        return new ProjectTask(
                id, title, "CSC 223", "2026-10-25", 1, false
        );
    }

    @Test
    void addsTaskAndIncreasesCount() {
        StudyPlanner planner = new StudyPlanner();

        planner.addTask(makeTask("A101", "Java Project"));

        assertEquals(1, planner.getTaskCount());
    }

    @Test
    void retrievesTaskById() {
        StudyPlanner planner = new StudyPlanner();
        planner.addTask(makeTask("A101", "Java Project"));

        assertEquals("Java Project", planner.getTask("A101").getTitle());
    }

    @Test
    void rejectsNullTask() {
        StudyPlanner planner = new StudyPlanner();

        assertThrows(
                IllegalArgumentException.class,
                () -> planner.addTask(null)
        );
    }

    @Test
    void rejectsDuplicateAssignmentId() {
        StudyPlanner planner = new StudyPlanner();
        planner.addTask(makeTask("A101", "Java Project"));

        assertThrows(
                IllegalArgumentException.class,
                () -> planner.addTask(makeTask("A101", "Another Project"))
        );
    }

    @Test
    void missingTaskCannotBeRetrieved() {
        StudyPlanner planner = new StudyPlanner();

        assertThrows(
                IllegalArgumentException.class,
                () -> planner.getTask("A999")
        );
    }

    @Test
    void updatesTaskDetails() {
        StudyPlanner planner = new StudyPlanner();
        planner.addTask(makeTask("A101", "Old Title"));

        planner.updateTask(
                "A101", "New Title", "CSC 223", "2026-10-28", 2
        );

        assertEquals("New Title", planner.getTask("A101").getTitle());
        assertEquals(2, planner.getTask("A101").getPriority());
    }

    @Test
    void removesTaskAndUpdatesCount() {
        StudyPlanner planner = new StudyPlanner();
        planner.addTask(makeTask("A101", "Java Project"));

        assertTrue(planner.removeTask("A101"));
        assertEquals(0, planner.getTaskCount());
    }

    @Test
    void removingMissingTaskReturnsFalse() {
        StudyPlanner planner = new StudyPlanner();

        assertFalse(planner.removeTask("A999"));
    }

    @Test
    void preservesOrderAfterRemoval() {
        StudyPlanner planner = new StudyPlanner();
        planner.addTask(makeTask("A101", "First"));
        planner.addTask(makeTask("A102", "Second"));
        planner.addTask(makeTask("A103", "Third"));

        planner.removeTask("A102");

        assertEquals("A101",
                planner.getAllTasks().get(0).getAssignmentId());
        assertEquals("A103",
                planner.getAllTasks().get(1).getAssignmentId());
    }

    @Test
    void countsCompletedAndIncompleteTasks() {
        StudyPlanner planner = new StudyPlanner();
        planner.addTask(makeTask("A101", "First"));

        planner.addTask(new ProjectTask(
                "A102", "Second", "CSC 223",
                "2026-10-25", 1, true
        ));

        assertEquals(2, planner.getTaskCount());
        assertEquals(1, planner.getCompletedTaskCount());
        assertEquals(1, planner.getIncompleteTaskCount());
    }

    @Test
    void emptyPlannerHasZeroTasks() {
        StudyPlanner planner = new StudyPlanner();

        assertEquals(0, planner.getTaskCount());
        assertEquals(0, planner.getCompletedTaskCount());
        assertEquals(0, planner.getIncompleteTaskCount());
        assertTrue(planner.getAllTasks().isEmpty());
    }
}

