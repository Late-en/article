package com.example.article.service;

import com.example.article.entity.Category;
import com.example.article.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author Late-en
 */
public interface CategoryService {
    boolean addCategory(Category Category);

    boolean deleteCategory(Serializable id);

    boolean updateCategoryInfo(Category Category);

    Category getCategoryInfo(String Categoryname);

    List<Category> allCategory();
}
