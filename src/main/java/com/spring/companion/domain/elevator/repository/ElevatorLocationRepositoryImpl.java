package com.spring.companion.domain.elevator.repository;

import com.spring.companion.domain.elevator.ElevatorLocation;
import com.spring.companion.domain.elevator.QElevatorLocation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ElevatorLocationRepositoryImpl implements ElevatorLocationCustomRepository {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<ElevatorLocation> findExternalEVBySubName(int line, String sub_name) {
        QElevatorLocation elevatorLocation=QElevatorLocation.elevatorLocation;
        // 역 이름으로 조회
        return queryFactory
                .select(elevatorLocation)
                .from(elevatorLocation)
                .where(elevatorLocation.line.eq(line),elevatorLocation.sub_name.eq(sub_name),elevatorLocation.elevator_loc.contains("출구"))
                .orderBy(elevatorLocation.elevator_loc.asc())
                .fetch();
    }

    //
    @Override
    public List<ElevatorLocation> findInternalEVBySubName(int line, String sub_name) {
        QElevatorLocation elevatorLocation=QElevatorLocation.elevatorLocation;
        // 역 이름으로 조회
        return queryFactory
                .select(elevatorLocation)
                .from(elevatorLocation)
                .where(elevatorLocation.sub_name.eq(sub_name).and(elevatorLocation.elevator_loc.contains("상행")
                        .or(elevatorLocation.elevator_loc.contains("하행"))
                        .or(elevatorLocation.elevator_loc.contains("외선"))
                        .or(elevatorLocation.elevator_loc.contains("내선"))))
                .orderBy(elevatorLocation.elevator_loc.asc())
                .fetch();
    }
}
