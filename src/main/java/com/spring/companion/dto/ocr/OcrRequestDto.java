package com.spring.companion.dto.ocr;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OcrRequestDto {
    private String filePath;  // 파일 경로

    private String fileName;  // 파일명

    private String ext;  // 확장자

    private String fullFileInfo;  // 전체 파일 경로

    public OcrRequestDto(String filePath, String fileName, String ext, String fullFileInfo){
        this.filePath=filePath;
        this.fileName=fileName;
        this.ext=ext;
        this.fullFileInfo=fullFileInfo;
    }

}
