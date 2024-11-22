package com.example.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.article.constant.PageResult;
import com.example.article.entity.Article;
import com.example.article.mapper.ArticleMapper;
import com.example.article.service.ArticleService;
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
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean addArticle(Article Article) {
        return articleMapper.insert(Article) == 1;
    }

    @Override
    public boolean deleteArticle(Serializable id) {
        return articleMapper.deleteById(id) == 1;
    }

    @Override
    public boolean updateArticleInfo(Article Article) {
        return articleMapper.updateById(Article) == 1;
    }

    @Override
    public Article getArticleInfo(Long id) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return articleMapper.selectOne(wrapper);
    }

    @Override
    public List<Article> AllArticle() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        return articleMapper.selectList(wrapper);
    }

    @Override
    public List<Article> searchArticle(Article example) {
        return articleMapper.searchArticle(example);
    }
}
