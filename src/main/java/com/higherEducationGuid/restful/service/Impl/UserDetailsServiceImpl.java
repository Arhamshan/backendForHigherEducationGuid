package com.higherEducationGuid.restful.service.Impl;


import com.higherEducationGuid.restful.model.User;
import com.higherEducationGuid.restful.service.UserService;
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

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public final UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        final User user = this.userService.lookup(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(),true,true,
                true, true, Collections.emptyList());
    }
}
