package com.hms.hms.MaintenanceFines.DTO;

public class FineMaintenanceDTO {
    private Long id;
    private Double amount;
    private String description;
    private String roomNumber;
    private String studentId;

    // Constructors
    public FineMaintenanceDTO() {
    }

    public FineMaintenanceDTO(Long id, Double amount, String description, String roomNumber, String studentId) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.roomNumber = roomNumber;
        this.studentId = studentId;
    }

    // Getters and setters
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "FineMaintenanceDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
