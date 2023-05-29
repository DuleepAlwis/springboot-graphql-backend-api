package com.onlinelearningplatform.controller;

import com.onlinelearningplatform.entity.UserEntity;
import com.onlinelearningplatform.model.GeneralResponseModel;
import com.onlinelearningplatform.model.LoginResponseModel;
import com.onlinelearningplatform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//@RestController
//@RequestMapping("/api/v1/user")
@Controller
public class UserController {

    static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    /*@PostMapping(value="/save")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        return new ResponseEntity<UserEntity>(this.userService.createUser(user), HttpStatus.OK);
    }*/

    @MutationMapping
    public GeneralResponseModel createUser(@Argument UserEntity user){
        logger.info("Creating a user : "+user.getUsername());
        System.out.println("Creating a user : "+user.getEmail());
        return this.userService.createUser(user);
    }

    @MutationMapping
    public LoginResponseModel login(@Argument String email,@Argument String password){
        logger.info("Loggin user "+email+" @"+new Date());
        return this.userService.login(email,password);

    }
    @QueryMapping
    public List<UserEntity> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
