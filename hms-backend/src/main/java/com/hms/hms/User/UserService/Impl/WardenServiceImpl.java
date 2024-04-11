package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.AdminMapper;
import com.hms.hms.User.AllUserMapper.WardenMapper;
import com.hms.hms.User.UserDataTransferObject.WardenDto;
import com.hms.hms.User.UserEntity.Admin;
import com.hms.hms.User.UserEntity.SubWarden;
import com.hms.hms.User.UserEntity.Warden;
import com.hms.hms.User.UserRepository.WardenRepository;
import com.hms.hms.User.UserService.WardenService;

import java.util.List;
import java.util.stream.Collectors;

public class WardenServiceImpl implements WardenService {
    private WardenRepository wardenRepository;
    @Override
    public WardenDto createWarden(WardenDto wardenDto) {
        Warden warden= WardenMapper.mapDtoToWarden(wardenDto);
        Warden savedWarden=wardenRepository.save(warden);
        return WardenMapper.mapWardenToDto(savedWarden);
    }

    @Override
    public WardenDto getWardenById(String userId) {
        Warden warden=wardenRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        return WardenMapper.mapWardenToDto(warden);
    }

    @Override
    public List<WardenDto> getAllWardens() {
        List<Warden> warden=wardenRepository.findAll();
        return warden.stream().map((warden1 -> WardenMapper.mapWardenToDto(warden1))).collect(Collectors.toList());
    }

    @Override
    public WardenDto updatedWarden(String userId, WardenDto updatedWarden) {
        Warden warden=wardenRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        warden.setFullName(updatedWarden.getFullName());
        warden.setAddress(updatedWarden.getAddress());
        warden.setDob(updatedWarden.getDob());
        warden.setEmail(updatedWarden.getEmail());
        warden.setGender(updatedWarden.getGender());
        warden.setNationality(updatedWarden.getNationality());
        warden.setRole(updatedWarden.getRole());
        warden.setContactNo(updatedWarden.getContactNo());
        warden.setPassword(updatedWarden.getPassword());

        Warden updatedWardenObj=wardenRepository.save(warden);

        return WardenMapper.mapWardenToDto(updatedWardenObj);
    }

    @Override
    public void deleteWarden(String userId) {
        Warden warden=wardenRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));

        wardenRepository.deleteById(userId);
    }
}
