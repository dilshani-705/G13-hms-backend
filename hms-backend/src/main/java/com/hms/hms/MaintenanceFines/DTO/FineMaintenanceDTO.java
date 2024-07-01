package com.hms.hms.MaintenanceFines.DTO;

public class FineMaintenanceDTO {
    private Long id;
    private Double amount;
    private String description;
    private Long roomId;
    private String roomNumber;

    public FineMaintenanceDTO(Long id, Double amount, String description, Long roomId, String roomNumber) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.roomId = roomId;
        this.roomNumber = roomNumber;
    }

    // Getters and setters (if needed) can be added here
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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "FineMaintenanceDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
