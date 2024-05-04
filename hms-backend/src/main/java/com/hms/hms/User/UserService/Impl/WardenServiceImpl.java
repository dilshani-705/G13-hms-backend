package com.hms.hms.User.UserService.Impl;

import com.hms.hms.User.AllUserMapper.WardenMapper;
import com.hms.hms.User.UserDataTransferObject.WardenDto;
import com.hms.hms.User.UserEntity.Warden;
import com.hms.hms.User.UserRepository.WardenRepository;
import com.hms.hms.User.UserService.WardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class WardenServiceImpl implements WardenService {
    private final WardenRepository wardenRepository;
    private PasswordEncoder passwordEncoder;

    private final WardenMapper wardenMapper;
    @Autowired
    public WardenServiceImpl(WardenRepository wardenRepository, PasswordEncoder passwordEncoder, WardenMapper wardenMapper) {
        this.wardenRepository = wardenRepository;
        this.passwordEncoder = passwordEncoder;
        this.wardenMapper = wardenMapper;
    }

    @Override
    public WardenDto createWarden(WardenDto wardenDto) {
        Warden warden= wardenMapper.mapDtoToWarden(wardenDto);
        Warden savedWarden=wardenRepository.save(warden);
        return wardenMapper.mapWardenToDto(savedWarden);
    }

    @Override
    public WardenDto getWardenById(String warden_id) {
        Warden warden=wardenRepository.findById(warden_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+warden_id));
        return wardenMapper.mapWardenToDto(warden);
    }

    @Override
    public List<WardenDto> getAllWardens() {
        List<Warden> warden=wardenRepository.findAll();
        return warden.stream().map(wardenMapper::mapWardenToDto).collect(Collectors.toList());
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
        warden.setLecturePost(updatedWarden.getLecturePost());
        if(updatedWarden.getPassword()!=null){
            warden.setPassword(updatedWarden.getPassword(),passwordEncoder);
        }

        wardenRepository.save(warden);

        return wardenMapper.mapWardenToDto(warden);
    }

    @Override
    public void deleteWarden(String warden_id) {
        Warden warden=wardenRepository.findById(warden_id)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+warden_id));

        wardenRepository.deleteById(warden_id);
    }
}
