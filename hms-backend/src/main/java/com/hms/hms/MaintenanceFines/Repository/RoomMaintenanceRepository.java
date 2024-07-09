package com.hms.hms.MaintenanceFines.Repository;

import com.hms.hms.MaintenanceFines.Entity.RoomMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomMaintenanceRepository extends JpaRepository<RoomMaintenance, Long> {
    Optional<RoomMaintenance> findByRoomNumber(String roomNumber);
}
