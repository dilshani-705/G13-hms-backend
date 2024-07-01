package com.hms.hms.MaintenanceFines.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room_maintenance")
public class RoomMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;

    @OneToMany(mappedBy = "roomMaintenance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FineMaintenance> finesMaintenance;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<FineMaintenance> getFinesMaintenance() {
        return finesMaintenance;
    }

    public void setFinesMaintenance(List<FineMaintenance> finesMaintenance) {
        this.finesMaintenance = finesMaintenance;
    }
}
