package com.onlinelearningplatform.repository;

import com.onlinelearningplatform.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "select * from user_tb where email=?1 and password=?2", nativeQuery = true)
    public UserEntity loginUser(String email, String password);

    @Query(value="select * from user_tb where email=?1",nativeQuery = true)
    public UserEntity getUserByEmail(String email);

    @Query(value = "select * from user_tb where username=?1", nativeQuery = true)
    public UserEntity getUserByUsername(String username);

    @Query(value = "select * from user_tb where email=?1 and active_status=?2", nativeQuery = true)
    public UserEntity getUserByEmailAndActiveStatus(String email, String activeStatus);
}
