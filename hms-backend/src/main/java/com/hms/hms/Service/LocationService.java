package com.hms.hms.Service;


import com.hms.hms.Dto.LocationDto;
import com.hms.hms.Entity.Location;
import com.hms.hms.Repo.LocationRepo;
import com.hms.hms.Util.VarList;
import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LocationService {
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private ModelMapper modelMapper;

    // Method to retrieve all locations from the location table
    public List<LocationDto> viewAll(){
        // Retrieve all locations from repository
        List<Location> locationList = locationRepo.findAll();
        // Convert to DTOs and return
        return modelMapper.map(locationList,new TypeToken<List<LocationDto>>(){}.getType());
    }

    // Method to search and return a location by their ID from the location table
    public LocationDto searchByID(int locationID){
        // Check if location exists
        if (locationRepo.existsById(locationID)){
            // Retrieve location from repository and map to DTO
            Location location = locationRepo.findById(locationID).orElse(null);
            return modelMapper.map(location,LocationDto.class);
        }else{
            // Return null if location not found
            return null;
        }
    }

    // Method to save a new location in the location table
    public String add(LocationDto locationDto){
        locationRepo.save(modelMapper.map(locationDto, Location.class));
        return VarList.RSP_SUCCESS;

    }

    // Method to update a location in the Location table
    public String update(LocationDto locationDto){
        locationRepo.save(modelMapper.map(locationDto,Location.class));
        return VarList.RSP_SUCCESS;
    }

    // Method to delete a location from the location table
    public String deleteByID(int locationID){
        // Check if location exists
        if (locationRepo.existsById(locationID)){
            // Delete a location from repository
            locationRepo.deleteById(locationID);
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating Location not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

}
