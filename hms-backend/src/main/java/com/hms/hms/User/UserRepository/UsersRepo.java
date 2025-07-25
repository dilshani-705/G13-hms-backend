package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface UsersRepo extends JpaRepository<User,String> {
   Optional<User> findUserByUserIDAndPassword(String userId,String password);
   User findUserByUserID(String userID);
}
