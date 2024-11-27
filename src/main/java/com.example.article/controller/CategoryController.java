package com.example.article.controller;

import com.example.article.entity.Category;
import com.example.article.service.CategoryService;
import com.example.article.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Late-en
 */

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ApiResponse addCategory(@RequestBody Category category){
        if(!categoryService.addCategory(category)){
            return ApiResponse.ofError("创建失败");
        }
        return ApiResponse.ofSuccess("创建成功", categoryService.getCategoryInfo(category.getCategoryName()));
    }


    /**
     * 返回所有
     */
    @GetMapping("")
    public ApiResponse allCategory() {
        return ApiResponse.ofSuccess("所有返回成功", categoryService.allCategory());
    }

    /**
     * 更新信息数据
     */
    @PostMapping("/update")
    public ApiResponse updateCategoryInfo(@RequestBody Category category){
        if(!categoryService.updateCategoryInfo(category)){
            return ApiResponse.ofError("修改失败");
        }
        return ApiResponse.ofSuccess("修改成功");
    }


    /**
     * 删除
     */
    @GetMapping("/delete")
    public ApiResponse deleteCategory(@RequestParam Long id){
        if(categoryService.deleteCategory(id)){
            return ApiResponse.ofSuccess("删除成功");
        } else return ApiResponse.ofError("删除失败");
    }
}