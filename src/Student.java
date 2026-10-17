
public class Student {

    private final String studentId;
    private String name;
    private final StudyPlanner studyPlanner;

    public Student(String studentId, String name) {
        if (studentId == null || studentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Student ID cannot be empty.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Student name cannot be empty.");
        }

        this.studentId = studentId;
        this.name = name;
        this.studyPlanner = new StudyPlanner();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public StudyPlanner getStudyPlanner() {
        return studyPlanner;
    }

    public void updateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Student name cannot be empty.");
        }

        this.name = name;
    }

    public int getAssignmentCount() {
        return studyPlanner.getTaskCount();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", assignmentCount=" + getAssignmentCount() +
                '}';
    }
}

