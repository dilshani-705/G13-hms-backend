package com.hms.hms.Service;

import com.hms.hms.Entity.MaintenanceDetail;
import com.hms.hms.Repo.MaintenanceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceDetailService {
    @Autowired
    private MaintenanceDetailRepository maintenanceDetailRepository;

    public List<MaintenanceDetail> getAllMaintenanceDetails(){
        return maintenanceDetailRepository.findAll();
    }

    public MaintenanceDetail saveMaintenanceDetail(MaintenanceDetail maintenanceDetail){
        return maintenanceDetailRepository.save(maintenanceDetail);
    }

    public void deleteMaintenanceDetail(Long id){
        maintenanceDetailRepository.deleteById(id);
    }
}
