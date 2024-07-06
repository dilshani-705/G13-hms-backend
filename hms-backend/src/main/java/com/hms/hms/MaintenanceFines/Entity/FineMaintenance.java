package com.hms.hms.MaintenanceFines.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fine_maintenance")
public class FineMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_number", referencedColumnName = "room_number", nullable = false)
    @JsonIgnore
    private RoomMaintenance roomMaintenance;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomMaintenance getRoomMaintenance() {
        return roomMaintenance;
    }

    public void setRoomMaintenance(RoomMaintenance roomMaintenance) {
        this.roomMaintenance = roomMaintenance;
    }

//    public Set<StudentMaintenance> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<StudentMaintenance> students) {
//        this.students = students;
//    }
}
