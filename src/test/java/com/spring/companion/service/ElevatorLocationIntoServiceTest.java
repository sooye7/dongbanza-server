package com.spring.companion.service;

import com.spring.companion.dto.elevator.ExternalElevatorResponseDto;
import com.spring.companion.service.elevator.ElevatorLocationIntoService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RequiredArgsConstructor
class ElevatorLocationIntoServiceTest {

    @Autowired
    private ElevatorLocationIntoService elevatorLocationIntoService;

//    @Test
//    public void getElevatorList(){
//        Map<String, Integer> param1=new HashMap<>();
//        Map<String, String> param2=new HashMap<>();
//        param1.put("line",1);
//        param2.put("sub_name","서울");
//
//        //List<ExternalElevatorResponseDto> elevatorLocationList = elevatorLocationIntoService.getExternalElevator(param1,param2);
//        System.out.println("서울");
//        System.out.println(elevatorLocationList);
//    }

}