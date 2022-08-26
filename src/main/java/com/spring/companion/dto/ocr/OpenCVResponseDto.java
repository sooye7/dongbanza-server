package com.spring.companion.dto.ocr;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OpenCVResponseDto {
    private String fullFileInfo;  // 처리된 이미지 저장 경로 (전체 파일 경로)

    public OpenCVResponseDto(String fullFileInfo){
        this.fullFileInfo=fullFileInfo;
    }
}
