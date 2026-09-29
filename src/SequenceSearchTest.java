import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequenceSearchTest {

    @Test
    void findExistingAssignment() {
        List<ProjectTask> tasks = new ArrayList<>();

        tasks.add(new ProjectTask(
                "A101",
                "Calculus Homework",
                "MTH 264",
                "2026-10-05",
                1,
                false
        ));

        tasks.add(new ProjectTask(
                "A102",
                "Java Project",
                "CSC 223",
                "2026-10-07",
                2,
                false
        ));

        ProjectTask result =
                SequenceSearch.findByAssignmentId(tasks, "A101");

        assertNotNull(result);
        assertEquals("A101", result.getAssignmentId());
    }

    @Test
    void findSecondAssignment() {
        List<ProjectTask> tasks = new ArrayList<>();

        tasks.add(new ProjectTask(
                "A101",
                "Calculus Homework",
                "MTH 264",
                "2026-10-05",
                1,
                false
        ));

        tasks.add(new ProjectTask(
                "A102",
                "Java Project",
                "CSC 223",
                "2026-10-07",
                2,
                false
        ));

        ProjectTask result =
                SequenceSearch.findByAssignmentId(tasks, "A102");

        assertNotNull(result);
        assertEquals("A102", result.getAssignmentId());
    }

    @Test
    void assignmentNotFound() {
        List<ProjectTask> tasks = new ArrayList<>();

        tasks.add(new ProjectTask(
                "A101",
                "Calculus Homework",
                "MTH 264",
                "2026-10-05",
                1,
                false
        ));

        ProjectTask result =
                SequenceSearch.findByAssignmentId(tasks, "A999");

        assertNull(result);
    }

    @Test
    void emptyListReturnsNull() {
        List<ProjectTask> tasks = new ArrayList<>();

        ProjectTask result =
                SequenceSearch.findByAssignmentId(tasks, "A101");

        assertNull(result);
    }

    @Test
    void singleItemList() {
        List<ProjectTask> tasks = new ArrayList<>();

        tasks.add(new ProjectTask(
                "A101",
                "Calculus Homework",
                "MTH 264",
                "2026-10-05",
                1,
                false
        ));

        ProjectTask result =
                SequenceSearch.findByAssignmentId(tasks, "A101");

        assertNotNull(result);
        assertEquals("A101", result.getAssignmentId());
    }

    @Test
    void nullTaskListThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SequenceSearch.findByAssignmentId(null, "A101")
        );
    }

    @Test
    void blankAssignmentIdThrowsException() {
        List<ProjectTask> tasks = new ArrayList<>();

        tasks.add(new ProjectTask(
                "A101",
                "Calculus Homework",
                "MTH 264",
                "2026-10-05",
                1,
                false
        ));

        assertThrows(
                IllegalArgumentException.class,
                () -> SequenceSearch.findByAssignmentId(tasks, "")
        );
    }
}
