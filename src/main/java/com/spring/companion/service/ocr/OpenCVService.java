package com.spring.companion.service.ocr;

import com.spring.companion.dto.ocr.OpenCVResponseDto;
import lombok.RequiredArgsConstructor;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenCVService {
    private static final String PROCESSED_FILE_DIR="C:/scan/";
    private static final int KERNEL_SIZE=51;
    private static  final int BLACK_POINT=66;
    private static  final int WHITE_POINT=127;

    public static OpenCVResponseDto imgScan(Mat inputFile, int row, int col, Mat filtered, Mat processedImg, String ext){
        processedImg=blackPointSelect(whitePointSelect(highPassFilter(inputFile,filtered, row, col).clone()));
        String fileFullInfo = FileUtil.mkdirForDate(PROCESSED_FILE_DIR)+"/"+ DateUtil.getTime() + "." + ext;
        Imgcodecs.imwrite(fileFullInfo,processedImg);
        System.out.println("fileFullInfo_Scan"+fileFullInfo);
        return new OpenCVResponseDto(fileFullInfo);  // 처리된 이미지 파일 경로
    }

    private static Mat highPassFilter(Mat inputFile, Mat filtered, int row, int col){
        if(row%2==0)
            row++;
        if(col%2==0)
            col++;

        Mat kernel=Mat.ones(row, col, CvType.CV_32FC1);
        System.out.println(kernel);
        kernel=kernel.mul(kernel, 1/((float)row * (float)col));
        //System.out.println(kernel);

        Imgproc.filter2D(inputFile, filtered, -1, kernel);

        filtered.convertTo(filtered,CvType.CV_32FC3);
        inputFile.convertTo(inputFile,CvType.CV_32FC3);
        System.out.println("fit"+filtered);

        Core.subtract(inputFile,filtered,filtered);

        System.out.println("filtered "+filtered);

        kernel=Mat.zeros(inputFile.size(),CvType.CV_32FC3);
        kernel.setTo(new Scalar(1,1,1));

        System.out.println("multiply");
        Core.multiply(kernel, new Scalar(127.0, 127.0,127.0), kernel);
        System.out.println(kernel);

        Imgproc.cvtColor(filtered,filtered,Imgproc.COLOR_RGBA2RGB);

        Core.add(filtered,kernel,filtered);

        filtered.convertTo(filtered,CvType.CV_8UC3);

        return filtered;

    }

    private static Mat whitePointSelect(Mat processedImg){
        Imgproc.threshold(processedImg,processedImg,WHITE_POINT,255,Imgproc.THRESH_TRUNC);
        Core.subtract(processedImg, new Scalar(0,0,0),processedImg);

        float tmp=(255.0f)/((float)WHITE_POINT-0);
        Core.multiply(processedImg, new Scalar(tmp,tmp,tmp),processedImg);
        return processedImg;
    }

    private static Mat blackPointSelect(Mat processedImg){
        Core.subtract(processedImg,new Scalar(BLACK_POINT,BLACK_POINT,BLACK_POINT),processedImg);

        float tmp=(255.0f)/(255.0f-BLACK_POINT);
        Core.multiply(processedImg,new Scalar(tmp,tmp,tmp),processedImg);
        return processedImg;
    }


}
