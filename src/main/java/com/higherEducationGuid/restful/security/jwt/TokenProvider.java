package com.higherEducationGuid.restful.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import com.higherEducationGuid.restful.AppConfig;
import com.higherEducationGuid.restful.model.User;
import com.higherEducationGuid.restful.service.IUserService;
import com.higherEducationGuid.restful.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 * Created by I.S.M. ARHAM on 5/19/2017.
 */
@Component
public class TokenProvider {

    private final String secretKey;

    private final long tokenValidityInMilliseconds;

    private final UserDetailsService userDetailService;

    @Autowired
    private IUserService iUserService;

    public TokenProvider(AppConfig config, UserDetailsService userDetailService) {
        this.secretKey = Base64.getEncoder()
                .encodeToString(config.getSecret().getBytes());
        this.tokenValidityInMilliseconds = 1000 * config.getTokenValidityInSeconds();
        this.userDetailService = userDetailService;
    }

    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + this.tokenValidityInMilliseconds);

        User user = this.iUserService.lookup(username);
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("userId", user.getId() + "");
        claims.put("name", user.getName());
        claims.put("role", user.getUserRole());
        claims.put("username", user.getUsername());
        claims.put("email", user.getEmail());

        return Jwts.builder().setId(UUID.randomUUID().toString())
                .setClaims(claims)
                .setSubject(username).setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS512, this.secretKey).setExpiration(validity)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        String username = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token)
                .getBody().getSubject();
        UserDetails userDetails = this.userDetailService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(userDetails, "",
                userDetails.getAuthorities());
    }
}
