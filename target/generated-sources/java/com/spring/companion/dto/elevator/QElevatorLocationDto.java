package com.spring.companion.dto.elevator;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.searchsubway.dto.elevator.QElevatorLocationDto is a Querydsl Projection type for ElevatorLocationDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QElevatorLocationDto extends ConstructorExpression<ElevatorLocationDto> {

    private static final long serialVersionUID = -773356239L;

    public QElevatorLocationDto(com.querydsl.core.types.Expression<Integer> line, com.querydsl.core.types.Expression<String> elevator_loc) {
        super(ElevatorLocationDto.class, new Class<?>[]{int.class, String.class}, line, elevator_loc);
    }

}

