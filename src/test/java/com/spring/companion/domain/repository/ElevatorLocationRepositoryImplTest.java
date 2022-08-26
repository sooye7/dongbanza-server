package com.spring.companion.domain.repository;

import com.spring.companion.domain.elevator.repository.ElevatorLocationRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class ElevatorLocationRepositoryImplTest {
    @Autowired
    private ElevatorLocationRepository elevatorLocationRepository;

    @Test
    public void getListOfSubwayStation(){
//        List<String> elevatorLocationList=elevatorLocationRepository.findExitBySubName("서울");
//        for(String elevatorLocation:elevatorLocationList)
//            System.out.println(elevatorLocation);
    }

}