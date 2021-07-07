package com.huan.utils;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author YueDong Huan
 * @Date 2021/7/7
 * @Email huanyued@163.com
 */
public class FileUtil {

    /**
     * 文件上传--根据当天日期创建文件夹
     * @param file
     * @param rootPath  文件夹路径
     * @param folder    文件夹
     * @return
     */
    public static String upload(MultipartFile file, String rootPath, String folder) {
        String strDate = DateUtil.getDays();
        String fileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        String fileSavePath = folder + File.separator + strDate + File.separator;
        try {
            File p = new File(rootPath + fileSavePath);
            if (!p.exists()) {
                p.mkdirs();
            }
            file.transferTo(new File(rootPath + fileSavePath + fileName));
        } catch (IOException e) {

        }

        return fileSavePath + fileName;
    }

}
