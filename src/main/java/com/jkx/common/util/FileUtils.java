package com.jkx.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * MultipartFile 转换城 File
 */
public class FileUtils {
    public static File multipartFileToFile(MultipartFile file) {
        File toFile = null;
        InputStream ins = null;
        if (file.isEmpty() || file.getSize() <= 0) {
            file = null;
        } else {
            try {
                ins = file.getInputStream();
                toFile = new File(file.getOriginalFilename());
                inputStreamToFile(ins, toFile);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert ins != null;
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return toFile;
    }

    private static void inputStreamToFile(InputStream ins, File file) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
