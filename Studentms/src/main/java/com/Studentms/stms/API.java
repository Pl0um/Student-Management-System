package com.Studentms.stms;

import com.Studentms.stms.model.Student;
import com.Studentms.stms.model.UndergraduateStudent;
import com.Studentms.stms.model.Course;
import com.Studentms.stms.model.Enrollment;
import com.Studentms.stms.model.EnrollmentRequest;
import com.Studentms.stms.model.GraduateStudent;

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


        // Endpoint to create a new graduate student
    @PostMapping("/graduate-students")
    public GraduateStudent createGraduateStudent(@RequestBody GraduateStudent graduateStudent) {
        students.add(graduateStudent);
        return graduateStudent;
    }

    
    // Endpoint to create a new undergraduate student
    @PostMapping("/undergraduate-students")
    public UndergraduateStudent createUndergraduateStudent(@RequestBody UndergraduateStudent undergraduateStudent) {
        students.add(undergraduateStudent);
        return undergraduateStudent;
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

        // Endpoint to add a grade to a student
        @PostMapping("/students/{id}/grades")
        public Student addGrade(@PathVariable String id, @RequestBody float grade) {
            Student student = getStudentById(id);
            if (student != null) {
                student.addGrade(grade);
            }
            return student;
        }
        
        // Endpoint to get a student's average grade
        @GetMapping("/students/{id}/average-grade")
        public float getAverageGrade(@PathVariable String id) {
            Student student = getStudentById(id);
            if (student != null) {
                return student.getAverageGrade();
            }
            return 0;
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

        // Get all students enrolled in a specific course
    @GetMapping("/courses/{id}/students")
    public List<Student> getStudentsInCourse(@PathVariable String id) {
        Course course = getCourseById(id);
        if (course != null) {
            return course.getEnrolledStudents();
        }
        return new ArrayList<>();
    }

}