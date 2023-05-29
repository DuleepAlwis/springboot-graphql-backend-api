package com.onlinelearningplatform.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student_course_tb")
public class StudentCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentEntity student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_course_id", referencedColumnName = "id")
    private TutorCourseEntity tutorCourse;

    public StudentCourseEntity() {
    }

    public StudentCourseEntity(long id, StudentEntity student) {
        this.id = id;
        this.student = student;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public TutorCourseEntity getStudentCourse() {
        return tutorCourse;
    }

    public void setStudentCourse(TutorCourseEntity tutorCourse) {
        this.tutorCourse = tutorCourse;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", student=" + student +
                '}';
    }
}
