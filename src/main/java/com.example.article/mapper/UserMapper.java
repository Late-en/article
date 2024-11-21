package com.example.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.article.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author Late-en
 */

@Repository
public interface UserMapper extends BaseMapper<User> {
//    @Select("<script>" +
//            "SELECT * " +
//            "  FROM user" +
//            "<where>" +
//            "   <if test='example.id != null and example.id != \"\" '>" +
//            "       AND id like CONCAT('%', #{example.id}, '%')" +
//            "   </if>" +
//            "   <if test='example.username != null and example.username != \"\" '>" +
//            "       AND username like CONCAT('%', #{example.username}, '%')" +
//            "   </if>" +
//            "</where>" +
//            "</script>")
//	PageResult<User> searchByExample(@Param("example") User example);
}
