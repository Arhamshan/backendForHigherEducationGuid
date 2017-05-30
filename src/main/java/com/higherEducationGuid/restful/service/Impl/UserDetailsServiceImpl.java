package com.higherEducationGuid.restful.service.Impl;


import com.higherEducationGuid.restful.model.User;
import com.higherEducationGuid.restful.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Collections;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by I.S.M. ARHAM on 5/19/2017.
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService iUserService;

    public UserDetailsServiceImpl() {

    }

    @Override
    public final UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        final User user = this.iUserService.lookup(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(),true,true,
                true, true, Collections.emptyList());
    }
}
