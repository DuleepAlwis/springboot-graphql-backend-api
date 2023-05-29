package com.onlinelearningplatform.repository;

import com.onlinelearningplatform.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity,Long>{

    @Query(value="select * from tutor_tb where name=?1",nativeQuery = true)
    public TutorEntity getTutorByname(String name);

    @Query(value="select * from tutor_tb where user_id=?1",nativeQuery = true)
    public TutorEntity getTutorByUserId(long id);
}