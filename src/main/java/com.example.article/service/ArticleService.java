package com.example.article.service;

import com.example.article.constant.PageResult;
import com.example.article.entity.Article;

import java.io.Serializable;
import java.util.List;

/**
 * @author Late-en
 */
public interface ArticleService {
    boolean addArticle(Article article);

    boolean deleteArticle(Serializable id);

    boolean updateArticleInfo(Article article);

    Article getArticleInfo(Long id);

    List<Article> AllArticle();

    PageResult<Article> searchArticle(Article example, Integer pageNum, Integer pageSize);
}
