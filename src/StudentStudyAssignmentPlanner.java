
public class StudentStudyAssignmentPlanner {

    public static void main(String[] args) {

        Student student = new Student("S101", "Kritika");
        StudyPlanner planner = student.getStudyPlanner();

        planner.addTask(new ProjectTask(
                "A101", "Calculus Homework", "MTH 264",
                "2026-10-20", 1, false));

        planner.addTask(new ProjectTask(
                "A102", "Java Project", "CSC 223",
                "2026-10-22", 2, false));

        planner.addTask(new ProjectTask(
                "A103", "Geology Lab", "GOL 105",
                "2026-10-24", 3, true));

        System.out.println("Student Study & Assignment Planner");
        System.out.println("----------------------------------");
        System.out.println("Student: " + student.getName());
        System.out.println("Student ID: " + student.getStudentId());

        System.out.println("\nAll assignments:");
        for (ProjectTask task : planner.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nAssignment summary:");
        System.out.println("Total: " + student.getAssignmentCount());
        System.out.println("Completed: " + planner.getCompletedTaskCount());
        System.out.println("Incomplete: " + planner.getIncompleteTaskCount());

        planner.updateTask(
                "A102", "Updated Java Project", "CSC 223",
                "2026-10-25", 1);

        System.out.println("\nAfter updating A102:");
        System.out.println(planner.getTask("A102"));

        planner.removeTask("A101");

        System.out.println("\nAfter removing A101:");
        for (ProjectTask task : planner.getAllTasks()) {
            System.out.println(task);
        }

        System.out.println("\nRemaining assignments: "
                + student.getAssignmentCount());
    }
}