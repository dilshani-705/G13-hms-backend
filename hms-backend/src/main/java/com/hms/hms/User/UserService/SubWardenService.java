package com.hms.hms.User.UserService;

import com.hms.hms.User.UserDataTransferObject.AdminDto;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;

import java.util.List;

public interface SubWardenService {
    SubWardenDto createSubWarden(SubWardenDto subWardenDto);
    SubWardenDto getSubWardenById(String subWarden_id);
    List<SubWardenDto> getAllSubWardens();
    SubWardenDto updatedSubWarden(String userId, SubWardenDto updatedSubAWarden);
    void deleteSubWarden(String userId);

}