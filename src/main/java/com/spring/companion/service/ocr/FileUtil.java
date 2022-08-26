package com.spring.companion.service.ocr;

import java.io.File;

public class FileUtil {
    public static String mkdirForDate(String uploadDir){
        String path = uploadDir + DateUtil.getDateTime(); //폴더 경로

        File Folder = new File(path);

        if (!Folder.exists()) {
            Folder.mkdirs();
        }
        return path;
    }
}
