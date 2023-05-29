package com.onlinelearningplatform.repository;

import com.onlinelearningplatform.entity.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity,Long> {
}
