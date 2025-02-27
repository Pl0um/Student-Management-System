package com.Studentms.stms;

import com.Studentms.stms.model.Student;
import com.Studentms.stms.model.Course;
import com.Studentms.stms.model.Enrollment;
import com.Studentms.stms.model.EnrollmentRequest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class API {
    
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Enrollment> enrollments = new ArrayList<>();

    // Endpoint to create a new student
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student newstudent) {;
        students.add(newstudent);
        return newstudent;
    }

    // Endpoint to get all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable String id) {
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Endpoint to create a new course
    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course newCourse) {
        courses.add(newCourse);
        return newCourse;
    }

    // Endpoint to get all courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses;
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable String id) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(id)) {
                return course;
            }
        }
        return null;
    }

@PostMapping("/enrollments")
public Enrollment enrollStudent(@RequestBody EnrollmentRequest enrollmentRequest) {
    // Find the student and course from the existing lists
    Student student = students.stream()
            .filter(s -> s.getStudentID().equals(enrollmentRequest.getStudentID()))
            .findFirst()
            .orElse(null);

    Course course = courses.stream()
            .filter(c -> c.getCourseCode().equals(enrollmentRequest.getCourseCode()))
            .findFirst()
            .orElse(null);

    // Check if student and course exist
    if (student == null || course == null) {
        throw new RuntimeException("Student or Course not found");
    }

    // Create the enrollment
    Enrollment enrollment = new Enrollment(student, course);
    enrollment.register();
    enrollments.add(enrollment);

    return enrollment;
}

    @GetMapping("/enrollments")
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    

}