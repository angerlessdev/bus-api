package com.civa.busapi.bus.infrastructure.persistence.jpa.repositories;

import com.civa.busapi.bus.domain.model.aggregates.BusBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusBrandRepository extends JpaRepository<BusBrand, Long> {
}
