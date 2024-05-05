package com.hms.hms.Controller;


import com.hms.hms.Dto.AssetItemDto;
import com.hms.hms.Dto.ResponseDto;
import com.hms.hms.Service.AssetItemService;
import com.hms.hms.Util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/assetItem")
@CrossOrigin
public class AssetItemController {
    @Autowired
    private AssetItemService assetItemService;
    @Autowired
    private ResponseDto responseDto;

    // Endpoint for viewing all asset items
    @GetMapping("/viewAll")
    public ResponseEntity viewAll() {
        try {
            // Call service layer to retrieve all asset items
            List<AssetItemDto> assetItemDtoList = assetItemService.viewAll();

            // Check if list is empty
            if (assetItemDtoList.isEmpty()) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of assets items");
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched all assets items");
            }
            responseDto.setContent(assetItemDtoList);
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

    // Endpoint for searching an assetItem by ID
    @GetMapping("/search/{assetItemID}")
    public ResponseEntity searchByAssetItemID(@PathVariable int assetItemID) {
        try {
            // Call service layer to search asset item by assetItem ID
            AssetItemDto assetItemDto = assetItemService.searchByAssetItemID(assetItemID);

            // Check if asset is found
            if (assetItemDto == null) {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("No records of the asset items");
            } else {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully fetched the asset item");
            }
            responseDto.setContent(assetItemDto);
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

    // Endpoint for adding a new asset
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody AssetItemDto assetItemDto) {


        try {
            // Call service to add new asset item
            String response = assetItemService.add(assetItemDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully added asset item");
                responseDto.setContent(assetItemDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
//            } else {
//                responseDto.setCode(VarList.RSP_DUPLICATED);
//                System.out.println("sd");
//                responseDto.setMessage("Asset item already exists");
//                responseDto.setContent(assetItemDto);
//                return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());

            // Handle exceptions
            responseDto.setCode(VarList.RSP_ERROR);
           // responseDto.setMessage(ex.getMessage());
            responseDto.setMessage("Asset item already exists");
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
        }
        return null;
    }

    // Endpoint for updating an asset item
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody AssetItemDto assetItemDto) {
        try {
            // Call service layer to update asset item
            String response = assetItemService.update(assetItemDto);

            // Check response from service
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully updated the asset item");
                responseDto.setContent(assetItemDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such an asset item");
                responseDto.setContent(assetItemDto);
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

    // Endpoint for deleting an asset item by asset item ID
    @DeleteMapping("/delete/{assetItemID}")
    public ResponseEntity deleteByAssetItemID(@PathVariable int assetItemID) {

        try {
            // Call service to delete asset item by asset item name
            String response = assetItemService.deleteByAssetItemID(assetItemID);
            if (response.equals(VarList.RSP_SUCCESS)) {
                responseDto.setCode(VarList.RSP_SUCCESS);
                responseDto.setMessage("Successfully deleted the asset item");
                responseDto.setContent(assetItemID);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else {
                responseDto.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDto.setMessage("Not found such an asset item");
                responseDto.setContent("asset item name: " + assetItemID);
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

    // Endpoint for getting the count of assets
    @GetMapping("/count")
    public ResponseEntity count() {
        try {
            // Call service layer to retrieve the count of asset items
            int assetItemCount = assetItemService.count();

            // Set response
            responseDto.setCode(VarList.RSP_SUCCESS);
            responseDto.setMessage("Successfully retrieved asset item count");
            responseDto.setContent(assetItemCount);
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
}