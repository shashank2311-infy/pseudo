package com.infy.sport.service.repository;

import com.infy.sport.service.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
}
