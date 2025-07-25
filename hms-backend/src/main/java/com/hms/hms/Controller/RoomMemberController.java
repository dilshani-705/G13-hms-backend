package com.hms.hms.Controller;

import com.hms.hms.Dto.AssetDto;
import com.hms.hms.Dto.ResponseDto;
import com.hms.hms.Dto.RoomMemberCheckRequest;
import com.hms.hms.Dto.RoomMemberDto;
import com.hms.hms.Service.RoomMemberService;
import com.hms.hms.Util.VarList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/roomMember")
@CrossOrigin
public class RoomMemberController {

    @Autowired
    private RoomMemberService roomMemberService;
    @Autowired
    private ResponseDto responseDto;
    
    private static final Logger logger = LoggerFactory.getLogger(RoomMemberController.class);


    // Endpoint for viewing all room members
    @GetMapping("/viewAllRoomMembers")
    public ResponseEntity viewAllRoomMembers() {
        try {
            // Call service layer to retrieve all room members
            List<RoomMemberDto> roomMemberDtoList = roomMemberService.viewAllRoomMembers();

            // Check if list is empty
            if (roomMemberDtoList.isEmpty()) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of room members");
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched all room members");
            }
            responseDto.setContent(roomMemberDtoList);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }



    // Endpoint for adding new room members with their roomNo
    @PostMapping("/addRoomMember")
    public ResponseEntity addRoomMember(@RequestBody RoomMemberDto roomMemberDto) {
        try {
            // Call service to add new room member
            String response = roomMemberService.addRoomMember(roomMemberDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully added a new member");
                responseDto.setContent(roomMemberDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            }

            // Check response from service
            else {
                responseDto.setCode(VarList.RSP_DUPLICATED);
                responseDto.setMessage("this room member already exists");
                responseDto.setContent(roomMemberDto);
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

    // Endpoint for updating a room member
    @PutMapping("/updateRoomMember")
    public ResponseEntity updateRoomMember(@RequestBody RoomMemberDto roomMemberDto) {
        try {
            // Call service layer to update room member
            String response = roomMemberService.updateRoomMember(roomMemberDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully updated the room member");
                responseDto.setContent(roomMemberDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such a room member");
                responseDto.setContent(roomMemberDto);
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

    // Endpoint for deleting a room member by room memberID
    @DeleteMapping("/deleteRoomMember/{memberID}")
    public ResponseEntity deleteRoomMemberByID(@PathVariable String memberID) {

        try {
            // Call service to delete room member by ID
            String response = roomMemberService.deleteRoomMemberByID(memberID);
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully deleted the room member");
                responseDto.setContent(memberID);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such an employee");
                responseDto.setContent("assetID: " + memberID);
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


    // Endpoint for deleting a room member by room member for duplicate memeber handling
    @DeleteMapping("/deleteMember/{member}")
    public ResponseEntity deleteRoomMemberByMember(@PathVariable String member) {

        try {
            // Call service to delete room member by ID
            String response = roomMemberService.deleteRoomMemberByMember(member);
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully deleted the room member");
                responseDto.setContent(member);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such an employee");
                responseDto.setContent(member);
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

    // Endpoint to check if any room member does not exist in the 'student' table
    @PostMapping("/checkRoomMembers")
    public ResponseEntity checkRoomMembers(@RequestBody RoomMemberCheckRequest request) {
        try {
            boolean exists = roomMemberService.checkRoomMembersExist(request);
            System.out.println(exists);
            if (exists) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("All members exist");
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("One or more members do not exist");
            }
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }

    // Endpoint for generating unique room number
    @GetMapping("/generateRoomNumber")
    public ResponseEntity generateRoomNumber(@RequestParam String hostel, @RequestParam String level) {
        try {
            String roomNumber = roomMemberService.generateUniqueRoomNumber(hostel, level);
            responseDto.setCode(VarList.RSP_SUCCESS);
            responseDto.setMessage("Successfully generated room number");
            responseDto.setContent(roomNumber);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }


}
