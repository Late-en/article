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
            "SELECT * " +
            "  FROM article" +
            "<where>" +
            "   <if test='example.categoryId != null and example.categoryId != \"\" '>" +
            "       AND category_id = #{example.categoryId}" +
            "   </if>" +
            "   <if test='example.state != null'>" +
            "       AND state = #{example.state}" +
            "   </if>" +
            "</where>" +
            "	LIMIT #{page}, #{limit}" +
            "</script>")
    List<Article> searchArticle(@Param("example") Article example, @Param("page") Integer page, @Param("limit") Integer limit);
}