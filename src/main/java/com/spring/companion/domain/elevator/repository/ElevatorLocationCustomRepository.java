package com.spring.companion.domain.elevator.repository;

import com.spring.companion.domain.elevator.ElevatorLocation;

import java.util.List;

public interface ElevatorLocationCustomRepository {
    public List<ElevatorLocation> findExternalEVBySubName(int line, String sub_name);  // 외부 엘리베이터 조회
    public List<ElevatorLocation> findInternalEVBySubName(int line, String sub_name);  // 내부 엘리베이터 조회 (상행)
}
