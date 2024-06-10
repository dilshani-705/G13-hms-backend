package com.hms.hms.Service;

import com.hms.hms.Entity.CleaningDetail;
import com.hms.hms.Repo.CleaningDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Service
public class CleaningDetailService {
    @Autowired
    private CleaningDetailRepository cleaningDetailRepository;

    public List<CleaningDetail> getAllCleaningDetails(){
        return cleaningDetailRepository.findAll();
    }

    public CleaningDetail saveCleaningDetail(CleaningDetail cleaningDetail){
        return cleaningDetailRepository.save(cleaningDetail);
    }

  public void deleteCleaningDetail(Long id){
        cleaningDetailRepository.deleteById(id);
  }


//  public void deleteById(Event.ID id){
//
//  }

}
