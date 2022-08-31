package com.spring.companion.controller.elevator;

import com.spring.companion.dto.elevator.ExternalElevatorResponseDto;
import com.spring.companion.dto.elevator.InternalElevatorResponseDto;
import com.spring.companion.service.elevator.ElevatorLocationIntoService;
import com.spring.companion.service.elevator.ElevatorLocationOutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ElevatorLocationController {

    private final ElevatorLocationIntoService elevatorLocationIntoService;
    private final ElevatorLocationOutService elevatorLocationOutService;

    @GetMapping("/elevator/in")
    public List<ExternalElevatorResponseDto> intoSubwayStation(@RequestParam Map<String, Integer> line, Map<String, String> sub_name){
        // 지하철역 출구 엘리베이터 조회 (외부 엘리베이터)
        return elevatorLocationIntoService.getExternalElevator(line,  sub_name);
    }

    // 승강장 번호 정보
    @GetMapping("/elevator/out")
    public List<InternalElevatorResponseDto> getOutOfSubwayStation(@RequestParam Map<String, Integer> line, Map<String, String> sub_name){
        // 지하철역 내부에 있는 엘리베이터 조회
        return elevatorLocationOutService.getInternalElevator(line, sub_name);
    }


}
