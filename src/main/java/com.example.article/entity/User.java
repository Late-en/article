package com.example.article.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.FieldFill.*;

/**
 * @Description  
 * @Date 2024-11-19 
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID =  1L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 头像
	 */
	private String userPic;

	/**
	 * 创建时间
	 */
	@TableField(fill = INSERT)
	private Date createTime;

	/**
	 * 修改时间
	 */
	@TableField(fill = INSERT_UPDATE)
	private Date updateTime;

}
