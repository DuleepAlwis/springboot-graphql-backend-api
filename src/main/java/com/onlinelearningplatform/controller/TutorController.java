package com.onlinelearningplatform.controller;

import com.onlinelearningplatform.entity.TutorEntity;
import com.onlinelearningplatform.model.GeneralResponseModel;
import com.onlinelearningplatform.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TutorController {

    @Autowired
    private TutorService tutorService;
    @MutationMapping
    public GeneralResponseModel createTutor(@Argument TutorEntity tutor){
        return this.tutorService.createTutor(tutor);
    }

    @QueryMapping
    public TutorEntity getTutorProfile(@Argument long userId){
        return this.tutorService.getTutorProfile(userId);
    }
}
