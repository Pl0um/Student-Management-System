public class StudentTest {
    public static void main(String[] args) {
        // Create a new student
        Student student = new Student("John Doe", 20, "S12345");

        // Test adding grades
        student.addGrade(85.5f);
        student.addGrade(90.0f);
        student.addGrade(78.5f);

        // Test getStudentID
        System.out.println("Student ID: " + student.getStudentID()); // Expected: S12345

        // Test getGrades
        System.out.println("Grades: " + student.getGrades()); // Expected: [85.5, 90.0, 78.5]

        // Test getAverageGrade
        System.out.println("Average Grade: " + student.getAverageGrade()); // Expected: 84.666664

        // Test adding more grades
        student.addGrade(88.0f);
        student.addGrade(92.5f);

        // Test getGrades after adding more grades
        System.out.println("Updated Grades: " + student.getGrades()); // Expected: [85.5, 90.0, 78.5, 88.0, 92.5]

        // Test getAverageGrade after adding more grades
        System.out.println("Updated Average Grade: " + student.getAverageGrade()); // Expected: 86.9

        // Test setStudentID
        student.setStudentID("S67890");
        System.out.println("Updated Student ID: " + student.getStudentID()); // Expected: S67890
    }
}