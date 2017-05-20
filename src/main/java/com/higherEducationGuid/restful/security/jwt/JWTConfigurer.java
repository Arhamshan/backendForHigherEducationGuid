package com.higherEducationGuid.restful.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import com.higherEducationGuid.restful.security.jwt.TokenProvider;

/**
 * Created by I.S.M. ARHAM on 5/19/2017.
 */
public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

        private final TokenProvider tokenProvider;

	public JWTConfigurer(TokenProvider tokenProvider) {
            this.tokenProvider = tokenProvider;
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            JWTFilter customFilter = new JWTFilter(this.tokenProvider);
            http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
        }

}
