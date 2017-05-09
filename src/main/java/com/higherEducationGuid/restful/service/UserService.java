package com.higherEducationGuid.restful.service;

import com.higherEducationGuid.restful.model.User;

import java.util.List;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */

public interface UserService {
    List<User> getUsersList();
    User getUserById(Long id);
    User addUser(User user);
    User editUser(User user);
    void deleteUser(Long id);
}
