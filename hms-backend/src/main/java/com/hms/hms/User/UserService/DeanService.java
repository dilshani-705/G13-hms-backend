package com.hms.hms.User.UserService;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.DeanDto;

import java.util.List;

public interface DeanService {
    DeanDto createDean(DeanDto deanDto);
    DeanDto getDeanById(String userId);
    List<DeanDto> getAllDeans();
    DeanDto updatedDean(String userId, DeanDto updatedDean);
    void deleteDean(String userId);

}
