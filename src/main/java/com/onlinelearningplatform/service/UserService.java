package com.onlinelearningplatform.service;

import com.onlinelearningplatform.config.auth.JWTTokenHelper;
import com.onlinelearningplatform.controller.UserController;
import com.onlinelearningplatform.entity.UserEntity;
import com.onlinelearningplatform.model.GeneralResponseModel;
import com.onlinelearningplatform.model.LoginResponseModel;
import com.onlinelearningplatform.repository.UserRepository;
import com.onlinelearningplatform.utility.PasswordUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    public LoginResponseModel login(String email, String password){
        BCryptPasswordEncoder encoder = PasswordUtility.getBcryptEncoder();
        UserEntity user = this.userRepository.getUserByEmail(email);
        //System.out.println("Email "+email+" password : "+encoder.encode(password)+" "+encoder.matches(password,user.getPassword()));
        boolean passwordMatched = user!=null?encoder.matches(password,user.getPassword()):false;
        LoginResponseModel response = new LoginResponseModel();

        if(passwordMatched){
            if(user.getActiveStatus().equals("YES")){
                response.setUser(user);
                //JWTTokenHelper jwt = new JWTTokenHelper();

                    //String token = jwt.generateToken(user);
                    //response.setToken(token);
                    response.setResponseStatus(true);
                    response.setResponseMessage(LoginResponseModel.AUTHENTICATION_SUCCESS);

            }else{
                response.setResponseStatus(false);
                response.setResponseMessage(LoginResponseModel.USER_NOT_ACTIVATED);
            }

        }else{
            response.setResponseStatus(false);
            response.setResponseMessage(LoginResponseModel.EMAIL_PASSWORD_INVALID);
        }
        return response;
    }

    public GeneralResponseModel createUser(UserEntity user){
        //String hashedPassword = PasswordUtility.generatePassword(user.getPassword());
        BCryptPasswordEncoder encoder = PasswordUtility.getBcryptEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActiveStatus("YES");
        user.setCreateDate(new Date());
        GeneralResponseModel response = new GeneralResponseModel();
        try{
            if(this.userRepository.save(user)!=null){
                response.setResponseMessage(GeneralResponseModel.USER_SAVED_SUCCESS);
                response.setResponseStatus(true);
            }else{
                response.setResponseMessage(GeneralResponseModel.ERROR_SAVING_USER);
                response.setResponseStatus(false);
            }
        } catch (Exception ex){
            logger.warn(ex.getMessage());
            response.setResponseStatus(false);
            response.setResponseMessage(ex.getMessage());
        }

        return response;
    }
    public UserEntity getUserByUsername(String username){
        return this.userRepository.getUserByUsername(username);
    }

    public Optional<UserEntity> getUserById(long id){
        return this.userRepository.findById(id);
    }

    public List<UserEntity> getAllUsers(){
        return this.userRepository.findAll();
    }

}
