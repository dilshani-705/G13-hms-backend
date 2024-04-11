package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.AdminMapper;
import com.hms.hms.User.AllUserMapper.SubWardenMapper;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserEntity.Admin;
import com.hms.hms.User.UserEntity.SubWarden;
import com.hms.hms.User.UserRepository.SubWardenRepository;
import com.hms.hms.User.UserService.SubWardenService;

import java.util.List;
import java.util.stream.Collectors;

public class SubWardenServiceImpl implements SubWardenService {
    private SubWardenRepository subWardenRepository;
    @Override
    public SubWardenDto createSubWarden(SubWardenDto subWardenDto) {
        SubWarden subWarden= SubWardenMapper.mapDtoToSubWarden(subWardenDto);
        SubWarden savedSubWarden=subWardenRepository.save(subWarden);
        return SubWardenMapper.mapSubWardenToDto(savedSubWarden);
    }

    @Override
    public SubWardenDto getSubWardenById(String userId) {
        SubWarden subWarden=subWardenRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        return SubWardenMapper.mapSubWardenToDto(subWarden);
    }

    @Override
    public List<SubWardenDto> getAllSubWardens() {
        List<SubWarden> subWarden=subWardenRepository.findAll();
        return subWarden.stream().map((subWarden1 -> SubWardenMapper.mapSubWardenToDto(subWarden1))).collect(Collectors.toList());
    }

    @Override
    public SubWardenDto updatedSubWarden(String userId, SubWardenDto updatedSubAWarden) {
        SubWarden subWarden=subWardenRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        subWarden.setFullName(updatedSubAWarden.getFullName());
        subWarden.setAddress(updatedSubAWarden.getAddress());
        subWarden.setDob(updatedSubAWarden.getDob());
        subWarden.setEmail(updatedSubAWarden.getEmail());
        subWarden.setGender(updatedSubAWarden.getGender());
        subWarden.setNationality(updatedSubAWarden.getNationality());
        subWarden.setRole(updatedSubAWarden.getRole());
        subWarden.setContactNo(updatedSubAWarden.getContactNo());
        subWarden.setPassword(updatedSubAWarden.getPassword());

        SubWarden updatedSubWardenObj=subWardenRepository.save(subWarden);

        return SubWardenMapper.mapSubWardenToDto(updatedSubWardenObj);
    }

    @Override
    public void deleteSubWarden(String userId) {
        SubWarden subWarden=subWardenRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));

        subWardenRepository.deleteById(userId);
    }
}
