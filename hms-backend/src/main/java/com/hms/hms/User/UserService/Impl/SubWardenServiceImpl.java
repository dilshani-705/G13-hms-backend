package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.SubWardenMapper;
import com.hms.hms.User.UserDataTransferObject.SubWardenDto;
import com.hms.hms.User.UserEntity.SubWarden;
import com.hms.hms.User.UserRepository.SubWardenRepository;
import com.hms.hms.User.UserService.SubWardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SubWardenServiceImpl implements SubWardenService {
    private final SubWardenRepository subWardenRepository;
     private final PasswordEncoder passwordEncoder;
    private final SubWardenMapper subWardenMapper;
    @Autowired
    public SubWardenServiceImpl(SubWardenRepository subWardenRepository, PasswordEncoder passwordEncoder, SubWardenMapper subWardenMapper) {
        this.subWardenRepository = subWardenRepository;
        this.passwordEncoder = passwordEncoder;
        this.subWardenMapper = subWardenMapper;
    }

    @Override
    public SubWardenDto createSubWarden(SubWardenDto subWardenDto) {
        SubWarden subWarden= subWardenMapper.mapDtoToSubWarden(subWardenDto);
        SubWarden savedSubWarden=subWardenRepository.save(subWarden);
        return subWardenMapper.mapSubWardenToDto(savedSubWarden);
    }

    @Override
    public SubWardenDto getSubWardenById(String subWarden_id) {
        SubWarden subWarden=subWardenRepository.findById(subWarden_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+subWarden_id));
        return subWardenMapper.mapSubWardenToDto(subWarden);
    }

    @Override
    public List<SubWardenDto> getAllSubWardens() {
        List<SubWarden> subWarden=subWardenRepository.findAll();
        return subWarden.stream().map(subWardenMapper::mapSubWardenToDto).collect(Collectors.toList());
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
        subWarden.setPassword(updatedSubAWarden.getPassword(), passwordEncoder);

        SubWarden updatedSubWardenObj=subWardenRepository.save(subWarden);

        return subWardenMapper.mapSubWardenToDto(updatedSubWardenObj);
    }

    @Override
    public void deleteSubWarden(String userId) {
        SubWarden subWarden=subWardenRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));

        subWardenRepository.deleteById(userId);
    }
}
