package com.spring.companion.domain.elevator.repository;

import com.spring.companion.domain.elevator.ElevatorLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorLocationRepository extends JpaRepository<ElevatorLocation,Long>, ElevatorLocationCustomRepository {

}
