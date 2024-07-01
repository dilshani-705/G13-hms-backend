package com.hms.hms.MaintenanceFines.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_maintenance")
public class StudentMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String studentId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomMaintenance roomMaintenance;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
