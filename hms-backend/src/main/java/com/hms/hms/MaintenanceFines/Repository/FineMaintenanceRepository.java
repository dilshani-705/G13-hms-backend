package com.hms.hms.MaintenanceFines.Repository;

import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO;
import com.hms.hms.MaintenanceFines.Entity.FineMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FineMaintenanceRepository extends JpaRepository<FineMaintenance, Long> {

    @Query("SELECT new com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO(fm.id, fm.amount, fm.description, rm.id, rm.roomNumber) " +
            "FROM FineMaintenance fm LEFT JOIN fm.roomMaintenance rm WHERE fm.studentId = :studentId")
    List<FineMaintenanceDTO> findByStudentId(@Param("studentId") String studentId);
}
