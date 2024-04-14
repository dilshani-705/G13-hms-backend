package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.MaintenanceSupervisorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/maintenance-supervisors")
public class MaintenanceSupervisorController {
    private MaintenanceSupervisorService maintenanceSupervisorService;
    //Add an maintenance supervisor
    @PostMapping
    public ResponseEntity<MaintenanceSupervisorDto> createMaintenanceSupervisor(@RequestBody MaintenanceSupervisorDto maintenanceSupervisorDto){
        MaintenanceSupervisorDto savedMaintenanceSupervisor=maintenanceSupervisorService.createMaintenanceSupervisor(maintenanceSupervisorDto);
        return new ResponseEntity<>(savedMaintenanceSupervisor, HttpStatus.CREATED);

    }
}
