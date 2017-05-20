package com.higherEducationGuid.restful.controller;

import com.higherEducationGuid.restful.HigherEducationGuidApplication;
import com.higherEducationGuid.restful.model.User;
import com.higherEducationGuid.restful.security.jwt.TokenProvider;
import com.higherEducationGuid.restful.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by I.S.M. ARHAM on 5/19/2017.
 */
@RestController
@CrossOrigin
public class AuthController {

    private final UserService userService;

    private final TokenProvider tokenProvider;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthController(PasswordEncoder passwordEncoder, UserService userService,
                          TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;

    }

    @GetMapping("/authenticate")
    public void authenticate() {
        // we don't have to do anything here
        // this is just a secure endpoint and the JWTFilter
        // validates the token
        // this service is called at startup of the app to check
        // if the jwt token is still valid
    }

    @PostMapping("/login")
    public String authorize(@Valid @RequestBody User loginUser,
                            HttpServletResponse response) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginUser.getUsername(), loginUser.getPassword());

        try {
            this.authenticationManager.authenticate(authenticationToken);
            return tokenProvider.createToken(loginUser.getUsername());
        }
        catch (AuthenticationException e) {
            //HigherEducationGuidApplication.logger.info("Security exception {}", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User signupUser) {
        if (this.userService.usernameExists(signupUser.getUsername())) {
            return "EXISTS";
        }

        signupUser.encodePassword(this.passwordEncoder);
        this.userService.save(signupUser);
        return this.tokenProvider.createToken(signupUser.getUsername());
    }
}
