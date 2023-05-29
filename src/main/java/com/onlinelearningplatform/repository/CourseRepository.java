package com.onlinelearningplatform.repository;

import com.onlinelearningplatform.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {

    @Query(value="select * from course_tb where name=?1",nativeQuery = true)
    public CourseEntity getCourseByName(String name);
}
