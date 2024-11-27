package com.example.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.article.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Late-en
 */

@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    @Select("<script>" +
            "SELECT a.*, u.*, c.* " +
            "  FROM article a " +
            "  LEFT JOIN user u ON a.create_user = u.id " +
            "  LEFT JOIN category c ON a.category_id = c.id " +
            "<where>" +
            "   <if test='example.category != null and example.category != \"\" '>" +
            "       AND category_id = #{example.category.categoryId}" +
            "   </if>" +
            "   <if test='example.state != null'>" +
            "       AND state = #{example.state}" +
            "   </if>" +
            "   <if test='example.createUser != null'>" +
            "       AND create_user = #{example.createUser.id}" +
            "   </if>" +
            "</where>" +
            "</script>")
    List<Article> searchArticle(@Param("example") Article example);
}
