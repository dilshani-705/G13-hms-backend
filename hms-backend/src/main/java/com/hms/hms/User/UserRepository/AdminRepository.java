package com.hms.hms.User.UserRepository;


import com.hms.hms.User.UserEntity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
}
