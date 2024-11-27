package com.example.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.article.entity.Article;
import com.example.article.mapper.ArticleMapper;
import com.example.article.service.ArticleService;
import com.example.article.utils.fileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * @Description
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    private static String path = System.getProperty("user.dir") + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "img" + System.getProperty("file.separator");
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

    @Override
    public boolean uploadCoverImg(MultipartFile pic, Long articleId) {
        String fileName = System.currentTimeMillis() + pic.getOriginalFilename();
        try {
            File dest = new File(path + "coverImg" + System.getProperty("file.separator") + fileName);
            QueryWrapper<Article> wrapper = new QueryWrapper<Article>().eq("id", articleId);
            Article article = Article.builder().id(articleId).coverImg(fileName).build();
            if(!fileUtils.fileTrans(pic, dest, articleMapper, article)) return false;
            return articleMapper.update(article, wrapper) != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
