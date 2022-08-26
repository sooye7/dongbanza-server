package com.spring.companion.dto.ocr;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OcrRequestDto2 {
    private String fullFileInfo;  // 전체 파일 경로

    public OcrRequestDto2(String fullFileInfo){
        this.fullFileInfo=fullFileInfo;
    }

}
