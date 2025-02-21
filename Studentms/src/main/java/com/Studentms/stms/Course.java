package com.Studentms.stms;

import java.util.*;

public class Course{
    private String courseName;
    private String courseCode; 
    private int creditHours;
    private List<Student> students;

    // constructor
    public Course(String courseName, String courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
        this.students = new ArrayList<>();
    }   

    public void enrollStudent(Student student){
        students.add(student);
    }

    // getters et setters
    public List<Student> getEnrolledStudents() {
        return students;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

}