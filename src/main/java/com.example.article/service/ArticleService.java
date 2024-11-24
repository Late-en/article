package com.example.article.service;

import com.example.article.entity.Article;
import org.springframework.web.multipart.MultipartFile;

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

    List<Article> searchArticle(Article example);

    boolean uploadCoverImg(MultipartFile pic, Long articleId);
}
