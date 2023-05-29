package com.onlinelearningplatform.controller;

import com.onlinelearningplatform.entity.CourseEntity;
import com.onlinelearningplatform.model.CourseModel;
import com.onlinelearningplatform.model.GeneralResponseModel;
import com.onlinelearningplatform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @MutationMapping
    public GeneralResponseModel createCourse(@Argument CourseModel course){
        return this.courseService.createCourse(course);
    }

    @QueryMapping
    public List<CourseEntity> getCoursesByUserId(@Argument long userId){
        return this.courseService.getCoursesByUserId(userId);
    }
}
