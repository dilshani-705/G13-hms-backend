package com.hms.hms.MaintenanceFines.Controller;

import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO;
import com.hms.hms.MaintenanceFines.Service.FineMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fineMaintenance")
public class FineMaintenanceController {
    private final FineMaintenanceService fineMaintenanceService;

    @Autowired
    public FineMaintenanceController(FineMaintenanceService fineMaintenanceService) {
        this.fineMaintenanceService = fineMaintenanceService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<FineMaintenanceDTO>> getFinesByStudentId(@PathVariable String studentId) {
        List<FineMaintenanceDTO> fines = fineMaintenanceService.findByStudentId(studentId);
        return ResponseEntity.ok(fines);
    }
}
