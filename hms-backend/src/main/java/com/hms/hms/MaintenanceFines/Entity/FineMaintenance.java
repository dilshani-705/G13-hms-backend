package com.hms.hms.MaintenanceFines.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fine_maintenance")
public class FineMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String description;

    @Column(name = "student_id")
    private String studentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", nullable = false)
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public RoomMaintenance getRoomMaintenance() {
        return roomMaintenance;
    }

    public void setRoomMaintenance(RoomMaintenance roomMaintenance) {
        this.roomMaintenance = roomMaintenance;
    }
}
