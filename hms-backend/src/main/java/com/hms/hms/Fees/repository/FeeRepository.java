package com.hms.hms.Fees.repository;

import com.hms.hms.Fees.entity.Fee;
import com.hms.hms.Fines.entity.Fines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeeRepository extends JpaRepository<Fee,Long> {
    List<Fee> findByTgNumberContainingIgnoreCase(String tgNumber);
    List<Fee> findByStatus(String status);
    List<Fee> findByStatusIsNull();
}
