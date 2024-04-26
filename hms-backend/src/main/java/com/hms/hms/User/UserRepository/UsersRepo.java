package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<User,String> {
    Optional<User> findOneByIdAndPassword(String userID, String password);

    User findUserById(String userID);
}
