package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.DeanMapper;
import com.hms.hms.User.UserDataTransferObject.DeanDto;
import com.hms.hms.User.UserEntity.Dean;
import com.hms.hms.User.UserRepository.DeanRepository;
import com.hms.hms.User.UserService.DeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DeanServiceImpl implements DeanService {
    private final DeanRepository deanRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public DeanServiceImpl(DeanRepository deanRepository) {
        this.deanRepository = deanRepository;
    }

    @Override
    public DeanDto createDean(DeanDto deanDto) {
        DeanMapper deanMapper=new DeanMapper();
        Dean dean= deanMapper.mapDtoToDean(deanDto);
        Dean savedDean=deanRepository.save(dean);
        return deanMapper.mapDeanToDto(savedDean);
    }

    @Override
    public DeanDto getDeanById(String dean_id) {
        DeanMapper deanMapper=new DeanMapper();
        Dean dean=deanRepository.findById(dean_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+dean_id));
        return deanMapper.mapDeanToDto(dean);
    }

    @Override
    public List<DeanDto> getAllDeans() {
        DeanMapper deanMapper=new DeanMapper();
        List<Dean> dean=deanRepository.findAll();
        return dean.stream().map((dean1 -> deanMapper.mapDeanToDto(dean1))).collect(Collectors.toList());
    }

    @Override
    public DeanDto updatedDean(String userId, DeanDto updatedDean) {
        DeanMapper deanMapper=new DeanMapper();
        Dean dean=deanRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        dean.setFullName(updatedDean.getFullName());
        dean.setAddress(updatedDean.getAddress());
        dean.setDob(updatedDean.getDob());
        dean.setEmail(updatedDean.getEmail());
        dean.setGender(updatedDean.getGender());
        dean.setNationality(updatedDean.getNationality());
        dean.setRole(updatedDean.getRole());
        dean.setContactNo(updatedDean.getContactNo());
        dean.setPassword(updatedDean.getPassword(),passwordEncoder);

        Dean updatedDeanObj=deanRepository.save(dean);

        return deanMapper.mapDeanToDto(updatedDeanObj);
    }

    @Override
    public void deleteDean(String userId) {
        Dean dean=deanRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));

        deanRepository.deleteById(userId);
    }
}
