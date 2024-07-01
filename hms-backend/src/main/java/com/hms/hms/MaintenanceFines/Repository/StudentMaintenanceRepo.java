package com.hms.hms.MaintenanceFines.Repository;

import com.hms.hms.MaintenanceFines.Entity.StudentMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentMaintenanceRepo extends JpaRepository<StudentMaintenance, Long> {
   Optional<StudentMaintenance> findByStudentId(String studentId);
}
