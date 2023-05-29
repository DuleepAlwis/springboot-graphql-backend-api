package com.onlinelearningplatform.repository;

import com.onlinelearningplatform.entity.TutorCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorCourseRepository extends JpaRepository<TutorCourseEntity,Long> {

    @Query(value="select * from tutor_course_tb where tutor_id=?1",nativeQuery = true)
    public List<TutorCourseEntity> getCoursesByTutorId(long tutorId);
}
