public class Enrollment {
    private Student student;
    private Course course;

    // constructor
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void register() {
        course.enrollStudent(student);
    }
}