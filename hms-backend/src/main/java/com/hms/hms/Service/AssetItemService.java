package com.hms.hms.Service;


import com.hms.hms.Dto.AssetItemDto;
import com.hms.hms.Entity.AssetItem;
import com.hms.hms.Repo.AssetItemRepo;
import com.hms.hms.Util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class AssetItemService {
    @Autowired
    private AssetItemRepo assetItemRepo;
    @Autowired
    private ModelMapper modelMapper;

    // Method to retrieve all asset items from the assetItem table
    public List<AssetItemDto> viewAll(){
        // Retrieve all asset items from repository
        List<AssetItem> AssetItemList = assetItemRepo.findAll();
        // Convert to DTOs and return
        return modelMapper.map(AssetItemList,new TypeToken<List<AssetItemDto>>(){}.getType());
    }

    // Method to search and return an Asset items by their ID from the AssetItems table
    public AssetItemDto searchByAssetItemID(int assetItemID){
        // Check if Asset exists
        if (assetItemRepo.existsById(assetItemID)){
            // Retrieve Asset items from repository and map to DTO
            AssetItem assetItem = assetItemRepo.findById(assetItemID).orElse(null);
            return modelMapper.map(assetItem,AssetItemDto.class);
        }else{
            // Return null if Asset item not found
            return null;
        }
    }

    // Method to save a new Asset item in the Asset Item table
    public String add(AssetItemDto assetItemDto){
        assetItemRepo.save(modelMapper.map(assetItemDto, AssetItem.class));
        return VarList.RSP_SUCCESS;

        // Check if Asset Name already exists
//        if(assetItemRepo.existsById(assetItemDto.getAssetItemID())){
//            // Return response indicating duplication
//            return VarList.RSP_DUPLICATED;
//        }else{
//            // Save new Asset to repository
//            assetItemRepo.save(modelMapper.map(assetItemDto, AssetItem.class));
//            // Return success response
//            return VarList.RSP_SUCCESS;
//        }
    }

    // Method to update an Asset in the Asset table
    public String update(AssetItemDto assetItemDto){
        // Check if Asset item exists
        if(assetItemRepo.existsById(assetItemDto.getAssetItemID())){
            // Update Asset item in repository
            assetItemRepo.save(modelMapper.map(assetItemDto,AssetItem.class));
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating Asset item not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    // Method to delete an Asset item from the Asset Item table
    public String deleteByAssetItemID(int assetItemID){
        // Check if Asset item exists
        if (assetItemRepo.existsById(assetItemID)){
            // Delete Asset item from repository
            assetItemRepo.deleteById(assetItemID);
            // Return success response
            return VarList.RSP_SUCCESS;
        }else{
            // Return response indicating Asset not found
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    // Method to retrieve the count of assetItems from the database
    public int count() {
        // Retrieve count of asset items from repository
        return (int) assetItemRepo.count();//cast from "long" into "int"
    }

}
