package com.hms.hms.MaintenanceFines.Controller;

import com.hms.hms.MaintenanceFines.DTO.RoomMaintenanceDTO;
import com.hms.hms.MaintenanceFines.Service.RoomMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomMaintenanceController {

    @Autowired
    private RoomMaintenanceService roomMaintenanceService;

    @GetMapping("/room-maintenance/{roomNumber}")
    public RoomMaintenanceDTO getRoomMaintenance(@PathVariable String roomNumber) {
        return roomMaintenanceService.getRoomMaintenanceByRoomNumber(roomNumber);
    }
}
