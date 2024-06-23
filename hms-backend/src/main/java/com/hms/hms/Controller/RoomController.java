package com.hms.hms.Controller;



import com.hms.hms.Dto.RoomDto;
import com.hms.hms.Dto.ResponseDto;
import com.hms.hms.Service.RoomService;
import com.hms.hms.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/room")
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private ResponseDto responseDto;

    // Endpoint for viewing all rooms
    @GetMapping("/viewAll")
    public ResponseEntity viewAll() {
        try {
            // Call service layer to retrieve all Rooms
            List<RoomDto> roomDtoList = roomService.viewAll();

            // Check if list is empty
            if (roomDtoList.isEmpty()) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of rooms");
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched all rooms");
            }
            responseDto.setContent(roomDtoList);
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

    // Endpoint for searching a room by ID
    @GetMapping("/search/{roomID}")
    public ResponseEntity searchByID(@PathVariable int roomID) {
        try {
            // Call service layer to search room by ID
            RoomDto roomDto = roomService.searchByID(roomID);

            // Check if room is found
            if (roomDto == null) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of the room");
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched the room");
            }
            responseDto.setContent(roomDto);
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

    // Endpoint for adding a room
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody RoomDto roomDto) {

        try {
            // Call service to add new room
            String response = roomService.add(roomDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Entered Room adding successfully");
                responseDto.setContent(roomDto);
               return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_DUPLICATED);
                responseDto.setMessage("You entered room already exists");
                responseDto.setContent(roomDto);
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


    // Endpoint for updating a room
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody RoomDto roomDto) {
        try {
            // Call service layer to update room
            String response = roomService.update(roomDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully updated the room");
                responseDto.setContent(roomDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_DUPLICATED);
                responseDto.setMessage("You entered room already exists");
                responseDto.setContent(roomDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            }
        } catch (Exception ex) {   //come to unique error in database as exception
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
    }

    // Endpoint for deleting a room by ID
    @DeleteMapping("/delete/{roomID}")
    public ResponseEntity deleteByID(@PathVariable int roomID) {

        try {
            // Call service to delete the room by ID
            String response = roomService.deleteByID(roomID);

            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully deleted the room");
                responseDto.setContent(roomID);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such a room");
                responseDto.setContent("room: " + roomID);
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
