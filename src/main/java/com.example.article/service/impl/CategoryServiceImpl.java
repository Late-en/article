package com.example.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.article.entity.Category;
import com.example.article.mapper.CategoryMapper;
import com.example.article.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper CategoryMapper;

    @Override
    public boolean addCategory(Category Category) {
        return CategoryMapper.insert(Category) == 1;
    }

    @Override
    public boolean deleteCategory(Serializable id) {
        return CategoryMapper.deleteById(id) == 1;
    }

    @Override
    public boolean updateCategoryInfo(Category Category) {
        return CategoryMapper.updateById(Category) == 1;
    }

    @Override
    public Category getCategoryInfo(String Categoryname) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("category_name", Categoryname);
        return CategoryMapper.selectOne(wrapper);
    }

    @Override
    public List<Category> allCategory() {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        return CategoryMapper.selectList(wrapper);
    }
}
