package com.hms.hms.MaintenanceFines.Controller;

import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO;
import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceView;
import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceViewDTO;
import com.hms.hms.MaintenanceFines.Entity.FineMaintenance;
import com.hms.hms.MaintenanceFines.Repository.FineMaintenanceRepository;
import com.hms.hms.MaintenanceFines.ResourceNotFoundException;
import com.hms.hms.MaintenanceFines.Service.FineMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fineMaintenance")
public class FineMaintenanceController {
    private final FineMaintenanceService fineMaintenanceService;

    @Autowired
    private  FineMaintenanceRepository fineMaintenanceRepository;
    public FineMaintenanceController(FineMaintenanceService fineMaintenanceService) {
        this.fineMaintenanceService = fineMaintenanceService;
    }

    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<List<FineMaintenanceDTO>> getFineMaintenanceByStudentId(@PathVariable String studentId) {
        try {
            List<FineMaintenanceDTO> fineMaintenance = fineMaintenanceService.getFinesByStudentId(studentId);
            return ResponseEntity.ok(fineMaintenance);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFine(@PathVariable Long id) {
        try {
            fineMaintenanceService.deleteFine(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFineMaintenance(@PathVariable Long id, @RequestBody FineMaintenanceDTO fineMaintenanceDTO) {
        try {
            FineMaintenance updatedFine = fineMaintenanceService.updateFineMaintenance(id, fineMaintenanceDTO);
            return ResponseEntity.ok(updatedFine);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating fine maintenance: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<FineMaintenanceViewDTO> getAllFineMaintenance() {
        return fineMaintenanceService.getAllFineMaintenance();
    }

    @GetMapping("/room/{roomNumber}")
    public List<FineMaintenanceViewDTO> getFinesByRoomNumber(@PathVariable String roomNumber) {
        return fineMaintenanceService.getFinesByRoomNumber(roomNumber);
    }

    @PostMapping
    public FineMaintenance createFine(@RequestBody FineMaintenanceDTO fineMaintenanceDTO) {
        return fineMaintenanceService.createFine(fineMaintenanceDTO);
    }
}
