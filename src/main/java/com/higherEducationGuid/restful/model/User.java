package com.higherEducationGuid.restful.model;

import javax.persistence.*;
import java.io.Serializable;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */


@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -7846548520504474888L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "username", length = 255)
    private String username;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;


    public User(){}

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String fullname, String email, String password, String address, Long phone) {
        this.id = id;
        this.name = fullname;
        this.email = email;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (id == null || obj == null || getClass() != obj.getClass())
            return false;
        User toCompare = (User) obj;
        return id.equals(toCompare.id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
