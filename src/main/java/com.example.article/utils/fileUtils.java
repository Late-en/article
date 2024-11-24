package com.example.article.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Late-en
 */
public class fileUtils {
    public static boolean fileTrans(MultipartFile file, File dest, BaseMapper mapper, Object entity){
        try {
            file.transferTo(dest);
            if(mapper.updateById(entity) != 1){
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
