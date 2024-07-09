package com.hms.hms.MaintenanceFines.DTO;

public class FineMaintenanceViewDTO {
    private Long id;
    private Double amount;
    private String description;
    private String roomNumber;

    public FineMaintenanceViewDTO(Long id, Double amount, String description, String roomNumber) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.roomNumber = roomNumber;
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

    @Override
    public String toString() {
        return "FineMaintenanceViewDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
