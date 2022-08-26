package com.spring.companion.dto.elevator;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ElevatorLocationDto {
    private Integer line;

    private String sub_name;

    private String elevator_code;

    private String section;

    private String elevator_loc;
}
