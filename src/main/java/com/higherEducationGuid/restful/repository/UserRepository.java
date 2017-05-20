package com.higherEducationGuid.restful.repository;

import com.higherEducationGuid.restful.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by I.S.M. ARHAM on 5/9/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
