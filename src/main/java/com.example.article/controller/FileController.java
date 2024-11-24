package com.example.article.controller;

import com.example.article.model.ApiResponse;
import com.example.article.service.ArticleService;
import com.example.article.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

@RestController
@RequestMapping(value="/data/img")
public class FileController {
    private static String path = System.getProperty("user.dir") + System.getProperty("file.separator") + "data";
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/userPic/{pic}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] userPic(@PathVariable String pic) throws Exception {
        File file = new File( path + System.getProperty("file.separator") + pic);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }

    @GetMapping(value = "/coverImg/{pic}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] coverImg(@PathVariable String pic) throws Exception {
        File file = new File(path + System.getProperty("file.separator") + pic);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }

    // 修改用户头像
    @PostMapping("/upload/userPic")
    public ApiResponse uploadUserPic(@RequestParam MultipartFile file, @RequestParam Long userId){
        if(userService.uploadUserPic(file, userId)){
            return ApiResponse.ofSuccess("认证图片上传成功");
        } else return ApiResponse.ofError("认证图片上传失败");
    }

    // 修改coverImg
    @PostMapping("/upload/coverImg")
    public ApiResponse uploadCoverImg(@RequestParam MultipartFile file, @RequestParam Long articleId){
        if(articleService.uploadCoverImg(file, articleId)){
            return ApiResponse.ofSuccess("认证图片上传成功");
        } else return ApiResponse.ofError("认证图片上传失败");
    }
}

