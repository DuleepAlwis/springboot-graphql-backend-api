package com.onlinelearningplatform.service;

import com.onlinelearningplatform.entity.TutorEntity;
import com.onlinelearningplatform.entity.UserEntity;
import com.onlinelearningplatform.model.GeneralResponseModel;
import com.onlinelearningplatform.repository.TutorRepository;
import com.onlinelearningplatform.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private UserRepository userRepository;

    public GeneralResponseModel createTutor(TutorEntity tutor){
        GeneralResponseModel response = new GeneralResponseModel();
        System.out.println(tutor);
        UserEntity user = this.userRepository.getById(tutor.getUser().getId());
        tutor.setUser(user);
        TutorEntity tutorExist = this.tutorRepository.getTutorByUserId(tutor.getUser().getId());

        if(tutorExist!=null){
            tutor.setId(tutorExist.getId());
        }
        if(this.tutorRepository.save(tutor)!=null){
            response.setResponseMessage(GeneralResponseModel.DATA_SAVED_SUCCESS);
            response.setResponseStatus(true);
        }else{
            response.setResponseMessage(GeneralResponseModel.ERROR_SAVING_DATA);
            response.setResponseStatus(false);
        }
        return response;
    }

    public TutorEntity getTutorProfile(long userId){

        TutorEntity tutor = this.tutorRepository.getTutorByUserId(userId);
        return tutor;
    }
}
