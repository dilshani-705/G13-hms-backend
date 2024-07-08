package com.hms.hms.MaintenanceFines.Repository;

import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO;
import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceView;
import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceViewDTO;
import com.hms.hms.MaintenanceFines.Entity.FineMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FineMaintenanceRepository extends JpaRepository<FineMaintenance, Long> {
    @Query("SELECT new com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO(fm.id, fm.amount, fm.description, rm.roomNumber, sm.studentId) " +
            "FROM FineMaintenance fm " +
            "JOIN fm.roomMaintenance rm " +
            "JOIN rm.students sm " +
            "WHERE sm.studentId = :studentId")
    List<FineMaintenanceDTO> findFinesByStudentId(@Param("studentId") String studentId);

    @Query("SELECT new com.hms.hms.MaintenanceFines.DTO.FineMaintenanceViewDTO(fm.id, fm.amount, fm.description, rm.roomNumber) " +
            "FROM FineMaintenance fm " +
            "JOIN fm.roomMaintenance rm")
    List<FineMaintenanceViewDTO> findAllFines();

    @Query("SELECT new com.hms.hms.MaintenanceFines.DTO.FineMaintenanceViewDTO(fm.id, fm.amount, fm.description, rm.roomNumber) " +
            "FROM FineMaintenance fm " +
            "JOIN fm.roomMaintenance rm " +
            "WHERE rm.roomNumber = :roomNumber")
    List<FineMaintenanceViewDTO> findFinesByRoomNumber(@Param("roomNumber") String roomNumber);
}
