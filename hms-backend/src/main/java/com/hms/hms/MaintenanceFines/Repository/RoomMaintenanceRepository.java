package com.hms.hms.MaintenanceFines.Repository;

import com.hms.hms.MaintenanceFines.DTO.RoomMaintenanceDTO;
import com.hms.hms.MaintenanceFines.Entity.RoomMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomMaintenanceRepository extends JpaRepository<RoomMaintenance, Long> {

    @Query("SELECT new com.hms.hms.MaintenanceFines.DTO.RoomMaintenanceDTO(rm.id, rm.roomNumber) " +
            "FROM RoomMaintenance rm WHERE rm.id = :id")
    RoomMaintenanceDTO findByIdWithFines(@Param("id") Long id);
}

