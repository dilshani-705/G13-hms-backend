package com.hms.hms.Service;


import com.hms.hms.Dto.RoomDto;
import com.hms.hms.Entity.Asset;
import com.hms.hms.Entity.Room;
import com.hms.hms.Repo.RoomRepo;
import com.hms.hms.Util.VarList;
import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private ModelMapper modelMapper;

    // Method to retrieve all rooms from the room table
    public List<RoomDto> viewAll(){
        // Retrieve all rooms from repository
        List<Room> roomList = roomRepo.findAll();
        // Convert to DTOs and return
        return modelMapper.map(roomList,new TypeToken<List<RoomDto>>(){}.getType());
    }

    // Method to search and return a room by their ID from the room table
    public RoomDto searchByID(int roomID){
        // Check if location exists
        if (roomRepo.existsById(roomID)){
            // Retrieve room from repository and map to DTO
            Room room = roomRepo.findById(roomID).orElse(null);
            return modelMapper.map(room, RoomDto.class);
        }else{
            // Return null if room not found
            return null;
        }
    }

    // Method to save a new room in the room table
    public String add(RoomDto roomDto){
        if(roomRepo.existsByRoomAndHostel(roomDto.getRoom(), roomDto.getHostel())){
            // Return response indicating duplication
            return VarList.RSP_DUPLICATED;
        }else{
            // Save new room to repository
            roomRepo.save(modelMapper.map(roomDto, Room.class));
            // Return success response
            return VarList.RSP_SUCCESS;
        }

    }

    // Method to update a room in the room table
    public String update(RoomDto roomDto){
        if(roomRepo.existsByRoomAndHostel(roomDto.getRoom(), roomDto.getHostel())){
            // Return response indicating duplication
            return VarList.RSP_DUPLICATED;
        }else{
            // Save new room to repository
            roomRepo.save(modelMapper.map(roomDto, Room.class));
            // Return success response
            return VarList.RSP_SUCCESS;
        }
    }

    // Method to delete a room from the room table
    public String deleteByID(int roomID){
        // Check if room exists
        if (roomRepo.existsById(roomID)){
            // Delete a room from repository
            roomRepo.deleteById(roomID);
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating room not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
