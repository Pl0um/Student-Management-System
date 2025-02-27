package com.Studentms.stms.model;

public class Enrollment {
    private Student student;
    private Course course;

    // Constructor
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    // Register the student in the course
    public void register() {
        course.enrollStudent(student);
    }

    // getters, setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}