package com.spring.companion.dto.elevator;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ElevatorLocationRequestDto {
    Integer line;
    String sub_name;
}
