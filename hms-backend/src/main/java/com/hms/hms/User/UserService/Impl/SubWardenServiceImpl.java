package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.SubWardenMapper;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserEntity.SubWarden;
import com.hms.hms.User.UserRepository.SubWardenRepository;
import com.hms.hms.User.UserService.SubWardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SubWardenServiceImpl implements SubWardenService {
    private final SubWardenRepository subWardenRepository;
    @Autowired
    public SubWardenServiceImpl(SubWardenRepository subWardenRepository) {
        this.subWardenRepository = subWardenRepository;
    }

    @Override
    public SubWardenDto createSubWarden(SubWardenDto subWardenDto) {
        SubWarden subWarden= SubWardenMapper.mapDtoToSubWarden(subWardenDto);
        SubWarden savedSubWarden=subWardenRepository.save(subWarden);
        return SubWardenMapper.mapSubWardenToDto(savedSubWarden);
    }

    @Override
    public SubWardenDto getSubWardenById(String subWarden_id) {
        SubWarden subWarden=subWardenRepository.findById(subWarden_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+subWarden_id));
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
