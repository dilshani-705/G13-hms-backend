package com.hms.hms.User.UserController;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.MaintenanceSupervisorDto;
import com.hms.hms.User.UserService.AdminService;
import com.hms.hms.User.UserService.MaintenanceSupervisorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/maintenance_supervisors")
public class MaintenanceSupervisorController {
    private MaintenanceSupervisorService maintenanceSupervisorService;
    //Add an maintenance supervisor
    @PostMapping
    public ResponseEntity<MaintenanceSupervisorDto> createMaintenanceSupervisor(@RequestBody MaintenanceSupervisorDto maintenanceSupervisorDto){
        MaintenanceSupervisorDto savedMaintenanceSupervisor=maintenanceSupervisorService.createMaintenanceSupervisor(maintenanceSupervisorDto);
        return new ResponseEntity<>(savedMaintenanceSupervisor, HttpStatus.CREATED);

    }
    //See all maintenance supervisors
    @GetMapping
    public ResponseEntity<List<MaintenanceSupervisorDto>>getAllMaintenanceSupervisors(){
        List<MaintenanceSupervisorDto>maintenanceSupervisor=maintenanceSupervisorService.getAllMaintenanceSupervisors();
        return ResponseEntity.ok(maintenanceSupervisor);
    }
    //See an maintenance supervisors
    @GetMapping("/{maintenanceSupervisorId}")
    public ResponseEntity<MaintenanceSupervisorDto>getMaintenanceSupervisorById(@PathVariable("maintenanceSupervisorId") String maintenanceSupervisor_id){
        MaintenanceSupervisorDto maintenanceSupervisorDto=maintenanceSupervisorService.getMaintenanceSupervisorById(maintenanceSupervisor_id);
        return ResponseEntity.ok(maintenanceSupervisorDto);
    }
}
