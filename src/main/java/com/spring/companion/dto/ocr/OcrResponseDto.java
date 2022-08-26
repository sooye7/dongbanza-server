package com.spring.companion.dto.ocr;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OcrResponseDto {
    private String text;

    public OcrResponseDto(String text){
        this.text=text;
    }

}
