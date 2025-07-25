package com.hms.hms.MaintenanceFines.Service;

import com.hms.hms.Fines.exception.ResourceNotFoundException;
import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceDTO;
import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceView;
import com.hms.hms.MaintenanceFines.DTO.FineMaintenanceViewDTO;
import com.hms.hms.MaintenanceFines.Entity.FineMaintenance;
import com.hms.hms.MaintenanceFines.Entity.RoomMaintenance;
import com.hms.hms.MaintenanceFines.Repository.FineMaintenanceRepository;
import com.hms.hms.MaintenanceFines.Repository.RoomMaintenanceRepository;
import com.hms.hms.MaintenanceFines.Repository.StudentMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FineMaintenanceService implements FineMaintenanceServiceInterface {
    private final FineMaintenanceRepository fineMaintenanceRepository;
    private final RoomMaintenanceRepository roomMaintenanceRepository;

    @Autowired
    public FineMaintenanceService(FineMaintenanceRepository fineMaintenanceRepository, RoomMaintenanceRepository roomMaintenanceRepository) {
        this.fineMaintenanceRepository = fineMaintenanceRepository;
        this.roomMaintenanceRepository = roomMaintenanceRepository;
    }

    @Override
    public List<FineMaintenanceDTO> getFinesByStudentId(String studentId) {
        List<FineMaintenanceDTO> fineMaintenance = fineMaintenanceRepository.findFinesByStudentId(studentId);
        return fineMaintenance;
    }

    public List<FineMaintenanceViewDTO> getAllFineMaintenance() {
        return fineMaintenanceRepository.findAllFines();
    }

    public List<FineMaintenanceViewDTO> getFinesByRoomNumber(String roomNumber) {
        return fineMaintenanceRepository.findFinesByRoomNumber(roomNumber);
    }

    public FineMaintenance createFine(FineMaintenanceDTO fineMaintenanceDTO) {
        try {
            // Retrieve RoomMaintenance entity based on room number
            RoomMaintenance roomMaintenance = roomMaintenanceRepository.findByRoomNumber(fineMaintenanceDTO.getRoomNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Room not found with room number: " + fineMaintenanceDTO.getRoomNumber()));

            // Create FineMaintenance entity
            FineMaintenance fineMaintenance = new FineMaintenance();
            fineMaintenance.setAmount(fineMaintenanceDTO.getAmount());
            fineMaintenance.setDescription(fineMaintenanceDTO.getDescription());
            fineMaintenance.setRoomMaintenance(roomMaintenance);

            // Save FineMaintenance entity
            return fineMaintenanceRepository.save(fineMaintenance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create fine: " + e.getMessage());
        }
    }

    public void deleteFine(Long id) {
        FineMaintenance fine = fineMaintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fine not found with id: " + id));
        fineMaintenanceRepository.delete(fine);
    }

    public FineMaintenance updateFineMaintenance(Long id, FineMaintenanceDTO fineMaintenanceDTO) {
        FineMaintenance fine = fineMaintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fine not found with id: " + id));

        RoomMaintenance roomMaintenance = roomMaintenanceRepository.findByRoomNumber(fineMaintenanceDTO.getRoomNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with room number: " + fineMaintenanceDTO.getRoomNumber()));

        fine.setAmount(fineMaintenanceDTO.getAmount());
        fine.setDescription(fineMaintenanceDTO.getDescription());
        fine.setRoomMaintenance(roomMaintenance);

        return fineMaintenanceRepository.save(fine);
    }

}
