package com.jkx.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

/**
 * MultipartFile 转换城 File
 * @author lx
 */
public class FileUtils {
    /**
     * MultipartFile 转换城 File
     * @param file excel文件
     * @return file
     */
    public static File multipartFileToFile(MultipartFile file) {
        File toFile = null;
        InputStream ins = null;
        if (!file.isEmpty() && file.getSize() > 0) {
            try {
                ins = file.getInputStream();
                toFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
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

    /**
     * 字节流 写入 文件
     * @param ins 流
     * @param file excel文件
     */
    private static void inputStreamToFile(InputStream ins, File file) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead;
            int len = 8192;
            byte[] buffer = new byte[len];
            while ((bytesRead = ins.read(buffer, 0, len)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert os != null;
                os.close();
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
