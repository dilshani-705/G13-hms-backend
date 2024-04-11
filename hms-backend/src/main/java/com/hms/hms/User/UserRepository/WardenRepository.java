package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserEntity.Warden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardenRepository extends JpaRepository<Warden,String > {
}
