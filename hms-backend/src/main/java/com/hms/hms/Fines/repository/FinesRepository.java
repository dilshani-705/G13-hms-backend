package com.hms.hms.Fines.repository;
import com.hms.hms.Fines.entity.Fines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinesRepository extends JpaRepository<Fines,Long> {
    List<Fines> findByTgNumberContainingIgnoreCase(String tgNumber);
    List<Fines> findByStatus(String status);
    List<Fines> findByStatusIsNull();
}
