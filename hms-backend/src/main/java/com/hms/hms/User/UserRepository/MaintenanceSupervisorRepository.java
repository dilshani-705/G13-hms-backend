package com.hms.hms.User.UserRepository;

import com.hms.hms.User.UserEntity.MaintenanceSupervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceSupervisorRepository extends JpaRepository<MaintenanceSupervisor,String> {
}
