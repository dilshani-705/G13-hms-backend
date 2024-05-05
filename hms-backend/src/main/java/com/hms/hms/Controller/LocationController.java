package com.hms.hms.Controller;



import com.hms.hms.Dto.LocationDto;
import com.hms.hms.Dto.ResponseDto;
import com.hms.hms.Service.LocationService;
import com.hms.hms.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/location")
@CrossOrigin
public class LocationController {
    @Autowired
    private LocationService locationService;
    @Autowired
    private ResponseDto responseDto;

    // Endpoint for viewing all locations
    @GetMapping("/viewAll")
    public ResponseEntity viewAll() {
        try {
            // Call service layer to retrieve all locations
            List<LocationDto> locationDtoList = locationService.viewAll();

            // Check if list is empty
            if (locationDtoList.isEmpty()) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of locations");
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched all locations");
            }
            responseDto.setContent(locationDtoList);
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

    // Endpoint for searching a location by ID
    @GetMapping("/search/{locationID}")
    public ResponseEntity searchByID(@PathVariable int locationID) {
        try {
            // Call service layer to search location by ID
            LocationDto locationDto = locationService.searchByID(locationID);

            // Check if location is found
            if (locationDto == null) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of the location");
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched the location");
            }
            responseDto.setContent(locationDto);
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

    // Endpoint for adding a location
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody LocationDto locationDto) {

        try {
            // Call service to add new location
            String response = locationService.add(locationDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully added location");
                responseDto.setContent(locationDto);
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
        return null;
    }


    // Endpoint for updating a location
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody LocationDto locationDto) {
        try {
            // Call service layer to update location
            String response = locationService.update(locationDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully updated the location");
                responseDto.setContent(locationDto);
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
        return null;
    }

    // Endpoint for deleting a location by ID
    @DeleteMapping("/delete/{locationID}")
    public ResponseEntity deleteByID(@PathVariable int locationID) {

        try {
            // Call service to delete the location by ID
            String response = locationService.deleteByID(locationID);
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully deleted the location");
                responseDto.setContent(locationID);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such a location");
                responseDto.setContent("location: " + locationID);
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
