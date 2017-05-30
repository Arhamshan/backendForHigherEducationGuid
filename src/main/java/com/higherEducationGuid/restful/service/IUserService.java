package com.higherEducationGuid.restful.service;

import com.higherEducationGuid.restful.model.User;

/**
 * Created by I.S.M. ARHAM on 5/22/2017.
 */
public interface IUserService {

     User lookup(String username);

     void save(User user);

     boolean usernameExists(String username);
}
