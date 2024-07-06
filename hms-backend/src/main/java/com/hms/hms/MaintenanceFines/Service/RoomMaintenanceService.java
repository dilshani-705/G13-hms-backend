package com.hms.hms.MaintenanceFines.Service;

import com.hms.hms.MaintenanceFines.DTO.RoomMaintenanceDTO;
import com.hms.hms.MaintenanceFines.Entity.RoomMaintenance;
import com.hms.hms.MaintenanceFines.Repository.RoomMaintenanceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomMaintenanceService {

    @Autowired
    private RoomMaintenanceRepository roomMaintenanceRepository;

    public RoomMaintenanceDTO getRoomMaintenanceByRoomNumber(String roomNumber) {
        RoomMaintenance roomMaintenance = roomMaintenanceRepository.findByRoomNumber(roomNumber)
                .orElseThrow(() -> new EntityNotFoundException("Room Maintenance not found with room number: " + roomNumber));
        return convertToDto(roomMaintenance);
    }

    public RoomMaintenanceDTO save(RoomMaintenanceDTO roomMaintenanceDTO) {
        RoomMaintenance roomMaintenance = convertToEntity(roomMaintenanceDTO);
        roomMaintenance = roomMaintenanceRepository.save(roomMaintenance);
        return convertToDto(roomMaintenance);
    }

    private RoomMaintenance convertToEntity(RoomMaintenanceDTO dto) {
        RoomMaintenance roomMaintenance = new RoomMaintenance();
        roomMaintenance.setId(dto.getId());
        roomMaintenance.setRoomNumber(dto.getRoomNumber());
        // Set other fields as needed
        return roomMaintenance;
    }

    private RoomMaintenanceDTO convertToDto(RoomMaintenance roomMaintenance) {
        RoomMaintenanceDTO dto = new RoomMaintenanceDTO();
        dto.setId(roomMaintenance.getId());
        dto.setRoomNumber(roomMaintenance.getRoomNumber());
        // Set other fields as needed
        return dto;
    }
}
