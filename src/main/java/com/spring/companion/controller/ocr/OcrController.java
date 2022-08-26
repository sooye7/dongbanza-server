package com.spring.companion.controller.ocr;

import com.spring.companion.dto.ocr.OcrResponseDto;
import com.spring.companion.service.ocr.OcrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class OcrController {

    private final OcrService ocrService;

    @PostMapping("/ocr/get")
    public OcrResponseDto getTextFromImage(@RequestPart(value="file",required = false) MultipartFile mf) throws Exception {
        return ocrService.readTextFromImage(mf);
    }
}
