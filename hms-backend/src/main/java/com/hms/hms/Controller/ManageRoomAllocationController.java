package com.hms.hms.Controller;

import com.hms.hms.Dto.AssetDto;
import com.hms.hms.Dto.ManageRoomAllocationDto;
import com.hms.hms.Dto.ResponseDto;
import com.hms.hms.Service.ManageRoomAllocationService;
import com.hms.hms.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping (value="/manageRoomAllocation")
@CrossOrigin
public class ManageRoomAllocationController {
    @Autowired
    private ManageRoomAllocationService manageRoomAllocationService;

    @Autowired
    private ResponseDto responseDto;

//    @GetMapping(value = "/searchRoom/{hostel}/{level}")
//    public List<String> searchRoomByHostelAndLevel(@PathVariable String hostel, @PathVariable String level) {
//        return manageRoomAllocationService.searchRoomByHostelAndLevel(hostel, level);
//    }


    // Endpoint for viewing all Room Allocation details
    @GetMapping("/viewAllDetails")
    public ResponseEntity viewAllDetails() {
        try {
            // Call service layer to retrieve all Room Allocation details
            List<ManageRoomAllocationDto> manageRoomAllocationDtoList = manageRoomAllocationService.viewAllDetails();

            // Check if list is empty
            if (manageRoomAllocationDtoList.isEmpty()) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of Rooms");
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched all Rooms");
                responseDto.setContent(manageRoomAllocationDtoList);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            }


        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }

    // Endpoint for searching the Room Allocation details by ID
    @GetMapping("/searchDetail/{hostel}/{level}")
    public ResponseEntity searchDetailByID(@PathVariable String hostel ,@PathVariable String level) {
        try {
            // Call service layer to search detail by ID
            List<ManageRoomAllocationDto> manageRoomAllocationDtoList = manageRoomAllocationService.searchDetailByID(hostel , level);


            // Check if detail is found
            if (manageRoomAllocationDtoList.isEmpty()) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of Your searching one");
                responseDto.setContent(manageRoomAllocationDtoList);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Details searching Successfully");
                responseDto.setContent(manageRoomAllocationDtoList);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }

    // Endpoint for adding a new Room Allocation detail
    @PostMapping("/addRoom")
    public ResponseEntity addRoom(@RequestBody ManageRoomAllocationDto manageRoomAllocationDto) {
        try {
            // Call service to add new Room Allocation detail
            String response = manageRoomAllocationService.addNewRoom(manageRoomAllocationDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully added new Room");
                responseDto.setContent(manageRoomAllocationDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_DUPLICATED);
                responseDto.setMessage("This Room is already reserved");
                responseDto.setContent(manageRoomAllocationDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }

    // Endpoint for updating an allocated room
    @PutMapping("/updateRoom/{allocationID}/{hostel}/{level}/{roomNo}/{updateRoomNo}")
    public ResponseEntity updateRoom(@PathVariable int allocationID , @PathVariable String hostel , @PathVariable String level , @PathVariable int roomNo , @PathVariable int updateRoomNo) {
        try {
            // Call service layer to update an allocated room
            String response = manageRoomAllocationService.updateRoom(allocationID , hostel , level , roomNo , updateRoomNo);

            ManageRoomAllocationDto manageRoomAllocationDto = manageRoomAllocationService.fetchUpdatedDetailByID(allocationID);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully updated the allocated room");
                responseDto.setContent(manageRoomAllocationDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else if(response.equals(VarList.SAME_UPDATED)){
                responseDto.setCode(VarList.SAME_UPDATED);
                responseDto.setMessage("You have not updated this RoomNo");
                responseDto.setContent(manageRoomAllocationDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            }else{
                responseDto.setCode(VarList.RSP_DUPLICATED);
                responseDto.setMessage("This Room is already reserved");
                responseDto.setContent(manageRoomAllocationDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }



    // Endpoint for deleting an Room Allocation detail by ID
    @DeleteMapping("/deleteRoom/{roomAllocationID}")
    public ResponseEntity deleteRoomByID(@PathVariable int roomAllocationID) {

        try {
            // Call service to delete Room Allocation detail by ID
            String response = manageRoomAllocationService.deleteRoomByID(roomAllocationID);
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully deleted the Room");
                responseDto.setContent(roomAllocationID);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such an Room");
                responseDto.setContent("roomAllocationID: " + roomAllocationID);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }
}


