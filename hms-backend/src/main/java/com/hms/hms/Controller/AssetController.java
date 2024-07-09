package com.hms.hms.Controller;


import com.hms.hms.Dto.AssetDto;
import com.hms.hms.Dto.ManageRoomAllocationDto;
import com.hms.hms.Dto.ResponseDto;
import com.hms.hms.Service.AssetService;
import com.hms.hms.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/asset")
@CrossOrigin
public class AssetController {
    @Autowired
    private AssetService assetService;
    @Autowired
    private ResponseDto responseDto;

    // Endpoint for viewing all employees
    @GetMapping("/viewAllAsset")
    public ResponseEntity viewAllAsset() {
        try {
            // Call service layer to retrieve all assets
            List<AssetDto> assetDtoList = assetService.viewAllAsset();

            // Check if list is empty
            if (assetDtoList.isEmpty()) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of assets");
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched all assets");
            }
            responseDto.setContent(assetDtoList);
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

    // Endpoint for searching an asset by ID
    @GetMapping("/searchDetail/{hostel}/{allocatedRoom}")
    public ResponseEntity searchDetailByID(@PathVariable String hostel , @PathVariable int allocatedRoom) {

        try {
            // Call service layer to search detail by ID
            List<AssetDto> assetDtoList = assetService.searchDetailByID(hostel , allocatedRoom);


            // Check if detail is found
            if (assetDtoList.isEmpty()) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of Your searching one");
                responseDto.setContent(assetDtoList);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Details searching Successfully");
                responseDto.setContent(assetDtoList);
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

    // Endpoint for adding a new asset
    @PostMapping("/addAsset")
    public ResponseEntity addAsset(@RequestBody AssetDto assetDto) {
        try {
            // Call service to add new asset detail
            String response = assetService.addNewAsset(assetDto);

            // Check response from service
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully added new Asset");
                responseDto.setContent(assetDto);
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

    // Endpoint for updating an asset
    @PutMapping("/updateAsset/{assetID}/{itemName}/{hostel}/{allocatedRoom}/{updateItemName}")
    public ResponseEntity<?> updateAsset(@PathVariable int assetID,
                                         @PathVariable String itemName,
                                         @PathVariable String hostel,
                                         @PathVariable int allocatedRoom,
                                         @PathVariable String updateItemName) {
        try {
            // Call service layer to update an asset
            String response = assetService.updateAsset(assetID, itemName, hostel, allocatedRoom, updateItemName);

            AssetDto assetDto = assetService.fetchUpdatedDetailByID(assetID);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully updated the asset");
                responseDto.setContent(assetDto);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            } else {
                responseDto.setCode(VarList.SAME_UPDATED);
                responseDto.setMessage("You have not updated this asset");
                responseDto.setContent(assetDto);
                return new ResponseEntity<>(responseDto, HttpStatus.NOT_MODIFIED);
            }

        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @PutMapping("/updateAsset")
//    public ResponseEntity updateAsset(@RequestBody AssetDto assetDto) {
//        try {
//            // Call service layer to update asset
//            String response = assetService.updateAsset(assetDto);
//
//            // Check response from service
//            if (response.equals(VarList.RSP_SUCCESS)) {
//                responseDto.setCode(VarList.RSP_SUCCESS);
//                responseDto.setMessage("Successfully updated the asset");
//                responseDto.setContent(assetDto);
//                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
//            } else {
//                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
//                responseDto.setMessage("Not found such an asset");
//                responseDto.setContent(assetDto);
//                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
//            }
//        } catch (Exception ex) {
//            System.out.println("ERROR: " + ex.getMessage());
//
//            // Handle exceptions
//            responseDto.setCode(VarList.RSP_ERROR);
//            responseDto.setMessage(ex.getMessage());
//            responseDto.setContent(null);
//            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
//        }
//    }

    // Endpoint for deleting an asset by ID
    @DeleteMapping("/deleteAsset/{assetID}")
    public ResponseEntity deleteAssetByID(@PathVariable int assetID) {

        try {
            // Call service to delete asset by ID
            String response = assetService.deleteAssetByID(assetID);
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully deleted the asset");
                responseDto.setContent(assetID);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such an employee");
                responseDto.setContent("assetID: " + assetID);
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

