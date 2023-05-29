package com.onlinelearningplatform.service;

import com.onlinelearningplatform.entity.UserEntity;
import com.onlinelearningplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = this.userRepository.getUserByEmailAndActiveStatus(username,"YES");

        if(user==null){
            throw new UsernameNotFoundException("User not found "+username);
        }
        return user;
    }
}
