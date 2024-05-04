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
    private final DeanMapper deanMapper;
    @Autowired
    public DeanServiceImpl(DeanRepository deanRepository, PasswordEncoder passwordEncoder, DeanMapper deanMapper) {
        this.deanRepository = deanRepository;
        this.passwordEncoder = passwordEncoder;
        this.deanMapper = deanMapper;
    }

    @Override
    public DeanDto createDean(DeanDto deanDto) {
        Dean dean= deanMapper.mapDtoToDean(deanDto);
        Dean savedDean=deanRepository.save(dean);
        return deanMapper.mapDeanToDto(savedDean);
    }

    @Override
    public DeanDto getDeanById(String dean_id) {
        Dean dean=deanRepository.findById(dean_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+dean_id));
        return deanMapper.mapDeanToDto(dean);
    }

    @Override
    public List<DeanDto> getAllDeans() {
        List<Dean> deans=deanRepository.findAll();
        return deans.stream().map(deanMapper::mapDeanToDto).collect(Collectors.toList());
    }

    @Override
    public DeanDto updatedDean(String dean_id, DeanDto updatedDean) {
        Dean dean=deanRepository.findById(dean_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+dean_id));
        dean.setFullName(updatedDean.getFullName());
        dean.setAddress(updatedDean.getAddress());
        dean.setDob(updatedDean.getDob());
        dean.setEmail(updatedDean.getEmail());
        dean.setGender(updatedDean.getGender());
        dean.setNationality(updatedDean.getNationality());
        dean.setRole(updatedDean.getRole());
        dean.setContactNo(updatedDean.getContactNo());
        if(updatedDean.getPassword()!=null){
            dean.setPassword(updatedDean.getPassword(),passwordEncoder);
        }
        deanRepository.save(dean);

        return deanMapper.mapDeanToDto(dean);
    }

    @Override
    public void deleteDean(String dean_id) {
        Dean dean=deanRepository.findById(dean_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+dean_id));

        deanRepository.deleteById(dean_id);
    }
}
