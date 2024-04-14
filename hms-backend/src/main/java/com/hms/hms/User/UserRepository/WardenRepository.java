package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserEntity.Warden;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardenRepository extends JpaRepository<Warden,String > {
}
