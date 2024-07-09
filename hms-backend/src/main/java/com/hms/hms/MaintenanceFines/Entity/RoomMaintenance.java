package com.hms.hms.MaintenanceFines.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room_maintenance")
public class RoomMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number", unique = true, nullable = false)
    private String roomNumber;

    @OneToMany(mappedBy = "roomMaintenance")
    @JsonIgnore // Prevent serialization of the students collection to avoid infinite recursion
    private List<StudentMaintenance> students;

    @OneToMany(mappedBy = "roomMaintenance", fetch = FetchType.LAZY)
    @JsonIgnore // Prevent serialization of the finesMaintenance collection to avoid infinite recursion
    private List<FineMaintenance> finesMaintenance;

//    @ManyToOne
//    @JoinColumn(name = "student_maintenance_id")
//    private StudentMaintenance studentMaintenance;


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

    public List<StudentMaintenance> getStudents() {
        return students;
    }

    public void setStudents(List<StudentMaintenance> students) {
        this.students = students;
    }

//    public StudentMaintenance getStudentMaintenance() {
//        return studentMaintenance;
//    }
//
//    public void setStudentMaintenance(StudentMaintenance studentMaintenance) {
//        this.studentMaintenance = studentMaintenance;
//    }


}
