import java.util.*;

public class Student extends Person {
    // private String name;
    private String studentID;
    // private int age;
    private List<Float> grades;


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
        float average =0;
        for (int i = 0 ; i < grades.size();i++){
            average += grades.get(i);
        }
        average /= grades.size();
        return average;
    }
}

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public List<Float> getGrades() {
        return grades;
    }
}