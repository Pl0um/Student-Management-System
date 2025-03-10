package com.Studentms.stms.model;

import java.util.*;

public class Student extends Person {
    private String studentID;
    private List<Float> grades;

    // constructor
    public Student(String name, int age, String studentID) {
        super(name, age);
        this.studentID = studentID;
        this.grades = new ArrayList<>();
    }


    public void addGrade(float grade){
        grades.add(grade);

    }
    public float getAverageGrade(){
        if (grades.isEmpty()) {
            return 0;
        }
        else {
        float average = 0;
        for (int i = 0 ; i < grades.size();i++ ){
            average += grades.get(i);
        }
        average /= grades.size();
        return average;
    }
}
    // getters et setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public List<Float> getGrades() {
        return grades;
    }
    public void setGrades(List<Float> grades) {
        this.grades = grades;
    }
}