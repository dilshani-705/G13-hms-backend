package com.hms.hms.MaintenanceFines.Repository;

import com.hms.hms.MaintenanceFines.Entity.StudentMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentMaintenanceRepository extends JpaRepository<StudentMaintenance, Long> {
   StudentMaintenance findByStudentId(String studentId);

   @Query("SELECT s FROM StudentMaintenance s WHERE s.roomMaintenance.id = :roomId")
   List<StudentMaintenance> findByRoomId(@Param("roomId") Long roomId);
}

