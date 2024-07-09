package com.hms.hms.Service;



import com.hms.hms.Dto.AssetDto;
import com.hms.hms.Dto.ManageRoomAllocationDto;
import com.hms.hms.Entity.Asset;
import com.hms.hms.Entity.ManageRoomAllocation;
import com.hms.hms.Repo.ManageRoomAllocationRepo;
import com.hms.hms.Util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class ManageRoomAllocationService {
    @Autowired
    private ManageRoomAllocationRepo manageRoomAllocationRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public List<String> searchRoomByHostelAndLevel(String hostel, String level) {
//        return manageRoomAllocationRepo.searchRoomByHostelAndLevel(hostel, level);
//    }


    // Method to retrieve all details from the manage room allocation table
    public List<ManageRoomAllocationDto> viewAllDetails() {
        // Retrieve all details from repository
        List<ManageRoomAllocation> manageRoomAllocationList = manageRoomAllocationRepo.findAll();
        // Convert to DTOs and return
        return modelMapper.map(manageRoomAllocationList, new TypeToken<List<ManageRoomAllocationDto>>() {
        }.getType());
    }

    // Method to search and return an detail by ID from the Manage Room Allocation table
    public  List<ManageRoomAllocationDto> searchDetailByID(String hostel , String level){
        // Retrieve only required details using by hostel and level from repository
            List<ManageRoomAllocation> manageRoomAllocationList = manageRoomAllocationRepo.findByRoomAndHostel(hostel, level);
            return modelMapper.map(manageRoomAllocationList, new TypeToken<List<ManageRoomAllocationDto>>() {
            }.getType());
    }

    // Method to save a new room allocation detail in the Allocation table
    public String addNewRoom(ManageRoomAllocationDto manageRoomAllocationDto) {
        // Check if This room allocation detail already exists
//        boolean duplicate01 = manageRoomAllocationRepo.duplicateSearch01(manageRoomAllocationDto.getHostel() , manageRoomAllocationDto.getLevel() , manageRoomAllocationDto.getRoomNo());

        boolean duplicateResult = manageRoomAllocationRepo.duplicateSearch01(manageRoomAllocationDto.getHostel() , manageRoomAllocationDto.getRoomNo());

        if (duplicateResult){
            // Return response indicating duplication
            return VarList.RSP_DUPLICATED;
        }else {
            // Save new room allocation detail to repository
            manageRoomAllocationRepo.save(modelMapper.map(manageRoomAllocationDto, ManageRoomAllocation.class));
            // Return success response
            return VarList.RSP_SUCCESS;
        }
    }


    // Method to update an Allocated room in the  manage room allocation table
    public String updateRoom(int allocationID , String hostel , String level ,  int roomNo , int updateRoomNo){
        // Check if Allocated room exists
        boolean duplicateResult = manageRoomAllocationRepo.duplicateSearch02(hostel , updateRoomNo);

        if (duplicateResult){
            if (roomNo == updateRoomNo){
                // Return update same room response
                return VarList.SAME_UPDATED;
            }else{
                // Return duplicate response
                return VarList.RSP_DUPLICATED;
            }
        }else{
            //update repository
            manageRoomAllocationRepo.updateRoom(allocationID , updateRoomNo);
            // Return success response
            return VarList.RSP_SUCCESS;
        }

    }

    public ManageRoomAllocationDto fetchUpdatedDetailByID(int allocationID){
        ManageRoomAllocation manageRoomAllocation = manageRoomAllocationRepo.fetchUpdatedDetailByID(allocationID);
        return modelMapper.map(manageRoomAllocation, new TypeToken<ManageRoomAllocationDto>() {
        }.getType());
    }

    // Method to delete a room allocation detail from the Room Allocation table
    public String deleteRoomByID(int roomAllocationID) {
        // Check if This room allocation detail exists
        if (manageRoomAllocationRepo.existsById(roomAllocationID)) {
            // Delete room allocation detail from repository
            manageRoomAllocationRepo.deleteById(roomAllocationID);
            // Return success response
            return VarList.RSP_SUCCESS;
        } else {
            // Return response indicating room allocation detail not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}



