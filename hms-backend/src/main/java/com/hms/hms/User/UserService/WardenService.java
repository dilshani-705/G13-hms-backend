package com.hms.hms.User.UserService;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.WardenDto;

import java.util.List;

public interface WardenService {
    WardenDto createWarden(WardenDto wardenDto);
    WardenDto getWardenById(String warden_id);
    List<WardenDto> getAllWardens();
    WardenDto updatedWarden(String userId, WardenDto updatedWarden);
    void deleteWarden(String userId);

}
