package com.higherEducationGuid.restful.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.higherEducationGuid.restful.model.User;
import com.higherEducationGuid.restful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by I.S.M. ARHAM on 5/19/2017.
 */
@Service
public class UserService implements IUserService {


    @Autowired
    UserRepository userRepository;

    public UserService() {

    }

    public User lookup(String username) {
        User user = userRepository.findByUsername(username) ;
        return user;
        //return userRepository.findByUsername(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public boolean usernameExists(String username) {
        User user =  userRepository.findByUsername(username);

        return user == null? false: true;
    }

}
