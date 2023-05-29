package com.onlinelearningplatform.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tutor_tb")
public class TutorEntity {

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

    @Column(name="qualification")
    private String qualification;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @OneToMany(mappedBy = "tutor")
    private List<TutorCourseEntity> tutorCourseEntity;

    public TutorEntity() {
    }

    public TutorEntity(long id, String name, String address, String city, String district, String country, String gender, String qualification, UserEntity user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.district = district;
        this.country = country;
        this.gender = gender;
        this.qualification = qualification;
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

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<TutorCourseEntity> getTutorCourseEntity() {
        return tutorCourseEntity;
    }

    public void setTutorCourseEntity(List<TutorCourseEntity> tutorCourseEntity) {
        this.tutorCourseEntity = tutorCourseEntity;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", qualification='" + qualification + '\'' +
                ", user=" + user +
                '}';
    }
}
