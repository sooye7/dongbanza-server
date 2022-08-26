package com.spring.companion.service.ocr;

import com.spring.companion.dto.ocr.OcrResponseDto;
import com.spring.companion.dto.ocr.OpenCVResponseDto;
import com.spring.companion.service.ocr.DateUtil;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import com.spring.companion.service.ocr.FileUtil;

import javax.imageio.ImageIO;

import static org.opencv.imgcodecs.Imgcodecs.imread;

@Service
@RequiredArgsConstructor
public class OcrService {

    final private String FILE_UPLOAD_SAVE_PATH = "C:/upload/";

    public OcrResponseDto readTextFromImage(MultipartFile mf) throws Exception {
        // 이미지 인식 후 결과 텍스트 반환
        return imageRecognition(extractFileInfo(mf));
    }

    // 파일 업로드
    public OpenCVResponseDto extractFileInfo(MultipartFile mf) throws Exception {
        // 업로드 하는 실제 파일명
        String originalFileName = mf.getOriginalFilename();
        System.out.println("originalFileName "+originalFileName);
        // 파일 확장자 가져오기
        String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length()).toLowerCase();
        //이미지 파일만 실행되도록 한다.
        if (ext.equals("jpeg") || ext.equals("jpg") || ext.equals("gif") || ext.equals("png")) {

            //웹서버에 저장되는 파일 이름
            String saveFileName = DateUtil.getTime() + "." + ext;
            //웹 서버에 업로드한 파일 저장하는 물리적 경로
            String saveFilePath = FileUtil.mkdirForDate(FILE_UPLOAD_SAVE_PATH);

            String fullFileInfo = saveFilePath + "/" + saveFileName;
            System.out.println("saveFileName "+saveFileName);
            System.out.println("saveFilePath "+saveFilePath);
            System.out.println("fullFileInfo "+fullFileInfo);

            //업로드 되는 파일을 서버에 저장
            mf.transferTo(new File(fullFileInfo));
            BufferedImage image= ImageIO.read(new File(fullFileInfo));
            int row=image.getHeight();
            int col=image.getWidth();

            Mat inputFile= Imgcodecs.imread(fullFileInfo);  // 이미지 파일 Mat로 읽어오기
            System.out.println(inputFile);
            return OpenCVService.imgScan(inputFile,row, col,  new Mat(), new Mat(), ext);  // 처리된 이미지 저장된 경로
            //return new OcrRequestDto(saveFilePath, saveFileName, ext, fullFileInfo);
        }
        else
            throw new Exception("인식이 불가능한 파일입니다.");
    }

    // 이미지 인식 (tesseract)
    public OcrResponseDto imageRecognition(OpenCVResponseDto openCVResponseDto) throws Exception {
        File imageFile=new File(openCVResponseDto.getFullFileInfo());
        System.out.println(imageFile);
        // ocr 기술 사용 위한 테서렉트 플랫폼 객체 생성
        ITesseract instance=new Tesseract();

        // ocr 분석에 필요한 기준 데이터, 저장 경로는 물리 경로 사용
        instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

        //File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        //Set the tessdata path
        //instance.setDatapath(tessDataFolder.getAbsolutePath());

        instance.setLanguage("kor");  // kor+eng

        // 이미지 파일로부터 텍스트 읽기
        String result=instance.doOCR(imageFile);

        return new OcrResponseDto(result);
    }

}