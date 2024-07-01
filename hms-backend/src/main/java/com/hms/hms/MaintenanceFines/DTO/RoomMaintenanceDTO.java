package com.hms.hms.MaintenanceFines.DTO;

public class RoomMaintenanceDTO {

    private Long id;
    private String roomNumber;

    // Constructors
    public RoomMaintenanceDTO() {
    }

    public RoomMaintenanceDTO(Long id, String roomNumber) {
        this.id = id;
        this.roomNumber = roomNumber;
    }

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
}
