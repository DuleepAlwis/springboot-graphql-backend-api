package com.onlinelearningplatform.repository;

import com.onlinelearningplatform.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    @Query(value="select * from student_tb where name=?1",nativeQuery = true)
    public StudentEntity getStudentByname(String name);
}
