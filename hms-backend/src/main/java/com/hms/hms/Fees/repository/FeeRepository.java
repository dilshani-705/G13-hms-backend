package com.hms.hms.Fees.repository;

import com.hms.hms.Fees.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepository extends JpaRepository<Fee,Long> {
}
