package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserEntity.SubWarden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubWardenRepository extends JpaRepository<SubWarden,String> {
}
