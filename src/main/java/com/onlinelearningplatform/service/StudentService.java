package com.onlinelearningplatform.service;

import com.onlinelearningplatform.entity.StudentEntity;
import com.onlinelearningplatform.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public StudentEntity getStudentByName(String name){
        return this.studentRepository.getStudentByname(name);
    }
}
