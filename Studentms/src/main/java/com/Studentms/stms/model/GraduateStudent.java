package com.Studentms.stms.model;

public class GraduateStudent extends Student {
    private String researchArea;
    private boolean isThesisSubmitted;

    public GraduateStudent(String name, int age, String studentID, String researchArea) {
        super(name, age, studentID);
        this.researchArea = researchArea;
        this.isThesisSubmitted = false;
    }

    // Override the getAverageGrade method to implement a different calculation for graduate students
    // Graduate students need a higher minimum grade to pass (consider only grades above 70)
    @Override
    public float getAverageGrade() {
        if (getGrades().isEmpty()) {
            return 0;
        }
        
        float sum = 0;
        int countValidGrades = 0;
        for (Float grade : getGrades()) {
            if (grade >= 70) {
                sum += grade;
                countValidGrades++;
            }
        }
        
        return countValidGrades > 0 ? sum / countValidGrades : 0;
    }

    // Getters and setters
    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    public boolean isThesisSubmitted() {
        return isThesisSubmitted;
    }

    public void setThesisSubmitted(boolean thesisSubmitted) {
        isThesisSubmitted = thesisSubmitted;
    }
}