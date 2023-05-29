package com.onlinelearningplatform.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tutor_course_tb")
public class TutorCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_id", referencedColumnName = "id")
    private TutorEntity tutor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity course;

    @OneToMany(mappedBy = "tutorCourse")
    private List<StudentCourseEntity> studentCourseEntities;

    public TutorCourseEntity() {
    }


    public TutorCourseEntity(long id, TutorEntity tutor, CourseEntity course) {
        this.id = id;
        this.tutor = tutor;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TutorEntity getTutor() {
        return tutor;
    }

    public void setTutor(TutorEntity tutor) {
        this.tutor = tutor;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public List<StudentCourseEntity> getStudentCourseEntities() {
        return studentCourseEntities;
    }

    public void setStudentCourseEntities(List<StudentCourseEntity> studentCourseEntities) {
        this.studentCourseEntities = studentCourseEntities;
    }

    @Override
    public String toString() {
        return "TutorCourse{" +
                "id=" + id +
                ", tutor=" + tutor +
                ", course=" + course +
                '}';
    }
}
