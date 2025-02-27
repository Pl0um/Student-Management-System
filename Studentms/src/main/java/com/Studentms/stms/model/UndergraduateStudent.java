package com.Studentms.stms.model;

public class UndergraduateStudent extends Student {
    private String major;
    private int yearLevel; // 1-4 representing freshman, sophomore, junior, senior

    public UndergraduateStudent(String name, int age, String studentID, String major, int yearLevel) {
        super(name, age, studentID);
        this.major = major;
        this.yearLevel = yearLevel;
    }

    // Override the getAverageGrade method 
    @Override
    public float getAverageGrade() {
        if (getGrades().isEmpty()) {
            return 0;
        }
        
        float weightedSum = 0;
        float weightSum = 0;
        
        for (int i = 0; i < getGrades().size(); i++) {
            // Apply increasing weight to more recent grades
            float weight = 1 + (i * 0.1f);
            weightedSum += getGrades().get(i) * weight;
            weightSum += weight;
        }
        
        return weightedSum / weightSum;
    }

    // Getters and setters
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }
    
    // Method to advance to next year level
    public void advanceYear() {
        if (yearLevel < 4) {
            yearLevel++;
        }
    }
}
