package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserEntity.Dean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeanRepository extends JpaRepository<Dean,String> {
}
