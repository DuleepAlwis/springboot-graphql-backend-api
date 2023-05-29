package com.onlinelearningplatform.service;

import com.onlinelearningplatform.entity.CourseEntity;
import com.onlinelearningplatform.entity.TutorCourseEntity;
import com.onlinelearningplatform.entity.TutorEntity;
import com.onlinelearningplatform.model.CourseModel;
import com.onlinelearningplatform.model.GeneralResponseModel;
import com.onlinelearningplatform.repository.CourseRepository;
import com.onlinelearningplatform.repository.TutorCourseRepository;
import com.onlinelearningplatform.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private TutorCourseRepository tutorCourseRepository;


    public GeneralResponseModel createCourse(CourseModel course){
        TutorEntity tutor = this.tutorRepository.getTutorByUserId(course.getUserId());
        GeneralResponseModel response = new GeneralResponseModel();

        if(tutor!=null){
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setName(course.getName());
            courseEntity.setDescription(course.getDescription());
            courseEntity.setPrice(course.getPrice());
            courseEntity.setDiscount(course.getPrice());
            courseEntity.setRating(course.getRating());
            courseEntity = this.courseRepository.save(courseEntity);
            if(courseEntity!=null){
                TutorCourseEntity tutorCourseEntity = new TutorCourseEntity();
                tutorCourseEntity.setCourse(courseEntity);
                tutorCourseEntity.setTutor(tutor);
                if(this.tutorCourseRepository.save(tutorCourseEntity)!=null){
                    response.setResponseStatus(true);
                    response.setResponseMessage(GeneralResponseModel.DATA_SAVED_SUCCESS);
                    return response;
                }

            }
        }
        response.setResponseStatus(false);
        response.setResponseMessage(GeneralResponseModel.ERROR_SAVING_DATA);
        return response;
    }

    public List<CourseEntity> getCoursesByUserId(long userId){
        List<TutorCourseEntity> tutorCourseEntities = new ArrayList<>();
        List<CourseEntity> courseEntities = new ArrayList<>();
        long tutorId = this.tutorRepository.getTutorByUserId(userId).getId();
        tutorCourseEntities = this.tutorCourseRepository.getCoursesByTutorId(tutorId);
        tutorCourseEntities.forEach(item->{
            CourseEntity course = this.courseRepository.getReferenceById(item.getCourse().getId());
            courseEntities.add(course);
        });
        System.out.println(courseEntities);
        return courseEntities;
    }
    public CourseEntity getCourseByName(String name){
        return this.courseRepository.getCourseByName(name);
    }
}
