package com.hms.hms.MaintenanceFines.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "student_maintenance")
public class StudentMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String studentId;

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
