
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void createsStudentWithIdAndName() {
        Student student = new Student("S101", "Kritika");

        assertEquals("S101", student.getStudentId());
        assertEquals("Kritika", student.getName());
        assertEquals(0, student.getAssignmentCount());
    }

    @Test
    void rejectsEmptyStudentId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("", "Kritika"));
    }

    @Test
    void rejectsEmptyStudentName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("S101", ""));
    }

    @Test
    void updatesStudentName() {
        Student student = new Student("S101", "Kritika");

        student.updateName("Kritika M.");

        assertEquals("Kritika M.", student.getName());
    }

    @Test
    void rejectsBlankUpdatedName() {
        Student student = new Student("S101", "Kritika");

        assertThrows(IllegalArgumentException.class,
                () -> student.updateName(" "));
    }

    @Test
    void studentCanManageAssignments() {
        Student student = new Student("S101", "Kritika");

        ProjectTask task = new ProjectTask(
                "A101", "Java Project", "CSC 223",
                "2026-10-25", 1, false);

        student.getStudyPlanner().addTask(task);

        assertEquals(1, student.getAssignmentCount());
        assertEquals("Java Project",
                student.getStudyPlanner().getTask("A101").getTitle());
    }
}
