package com.onlinelearningplatform.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="student_tb")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="district")
    private String district;

    @Column(name="country")
    private String country;

    @Column(name="gender")
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @OneToMany(mappedBy = "student")
    private List<StudentCourseEntity> studentCourseEntity;

    public StudentEntity() {
    }

    public StudentEntity(long id, String name, String address, String city, String district, String country, String gender, UserEntity user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.district = district;
        this.country = country;
        this.gender = gender;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<StudentCourseEntity> getStudentCourseEntity() {
        return studentCourseEntity;
    }

    public void setStudentCourseEntity(List<StudentCourseEntity> studentCourseEntity) {
        this.studentCourseEntity = studentCourseEntity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
