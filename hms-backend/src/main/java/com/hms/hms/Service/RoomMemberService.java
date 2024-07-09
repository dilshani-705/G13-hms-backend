package com.hms.hms.Service;

import com.hms.hms.Dto.RoomMemberCheckRequest;
import com.hms.hms.Dto.RoomMemberDto;
import com.hms.hms.Entity.Asset;
import com.hms.hms.Entity.RoomMember;
import com.hms.hms.Repo.RoomMemberRepo;
import com.hms.hms.Util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class RoomMemberService {

    int dCount=0;
    int count=0;
    @Autowired
    private RoomMemberRepo roomMemberRepo;
    @Autowired
    private ModelMapper modelMapper;

    // Method to retrieve all room member from the room member table
    public List<RoomMemberDto> viewAllRoomMembers(){
        // Retrieve all room members from repository
        List<RoomMember> RoomMemberList = roomMemberRepo.findAll();
        // Convert to DTOs and return
        return modelMapper.map(RoomMemberList,new TypeToken<List<RoomMemberDto>>(){}.getType());
    }


    // Method to save a new room member in the room member table
    public String addRoomMember(RoomMemberDto roomMemberDto){


        // Check if member ID already exists
        if(roomMemberRepo.existsById(roomMemberDto.getMemberID())){
            // Return response indicating duplication
            return VarList.RSP_DUPLICATED;
        }else{

            // Save new member to repository
            roomMemberRepo.save(modelMapper.map(roomMemberDto, RoomMember.class));
            // Return success response
            return VarList.RSP_SUCCESS;
        }
//            if (count == 4){
//                count = 0;
//            }

    }





    // Method to update a room member in the room member table
    public String updateRoomMember( RoomMemberDto roomMemberDto){
        // Check if room member exists
        if(roomMemberRepo.existsById(roomMemberDto.getMemberID())){
            // Update room member in repository
            roomMemberRepo.save(modelMapper.map(roomMemberDto,RoomMember.class));
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating room member not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    // Method to delete a room member from the room member table
    public String deleteRoomMemberByID(String memberID){
        // Check if room member exists
        if (roomMemberRepo.existsById(memberID)){
            // Delete room member from repository
            roomMemberRepo.deleteById(memberID);
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating room member not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    // Method to delete a room member from the room member table for duplicate memeber handling
    public String deleteRoomMemberByMember(String member){
        // Check if room member exists
        if (roomMemberRepo.existsById(member)){
            // Delete room member from repository
            roomMemberRepo.deleteById(member);
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating room member not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }


    public boolean checkRoomMembersExist(RoomMemberCheckRequest request) {
        for (String memberId : request.getRoomMembers()) {
            boolean exists = roomMemberRepo.existsByMemberIdAndHostelIdAndLevel(memberId , request.getHostel(), request.getLevel());
            System.out.println(exists);
            if (!exists) {
                return false;
            }
        }
        return true;
    }

    public String generateUniqueRoomNumber(String hostel, String level) {
        // Fetch existing room numbers for the given hostel and level
        List<String> existingRoomNumbers = roomMemberRepo.findRoomNumbersByHostelAndLevel(hostel, level);


        // Generate a room number randomly from the existingRoomNumbers list
        Random random = new Random();


        boolean result;
        String newRoomNumber;
        do {
            int index = random.nextInt(existingRoomNumbers.size());
            newRoomNumber = existingRoomNumbers.get(index);

            result = roomMemberRepo.findDuplicateRoomNo(hostel, newRoomNumber);
        } while (result);

        return newRoomNumber;
    }


}
