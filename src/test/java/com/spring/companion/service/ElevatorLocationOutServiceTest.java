package com.spring.companion.service;

import com.spring.companion.dto.elevator.InternalElevatorResponseDto;
import com.spring.companion.service.elevator.ElevatorLocationOutService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RequiredArgsConstructor
class ElevatorLocationOutServiceTest {

    @Autowired
    private ElevatorLocationOutService elevatorLocationOutService;

    @Test
    public void getElevatorList(){
        Map<String, Integer> param1=new HashMap<>();
        Map<String, String> param2=new HashMap<>();
        param1.put("line",1);
        param2.put("sub_name","시청");

        List<InternalElevatorResponseDto> elevatorLocationList = elevatorLocationOutService.getInternalElevator(param1,param2);
        System.out.println("시청");
        System.out.println(elevatorLocationList);
    }

}