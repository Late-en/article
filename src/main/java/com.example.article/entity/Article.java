package com.example.article.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Date 2024-11-19 
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

	private static final long serialVersionUID =  1L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 文章标题
	 */
	private String title;

	/**
	 * 文章内容
	 */
	private String content;

	/**
	 * 文章封面
	 */
	private String coverImg;

	/**
	 * 文章状态: 只能是[已发布] 或者 [草稿]
	 */
	private String state;

	/**
	 * 文章分类ID
	 */
	private Long categoryId;

	/**
	 * 创建人ID
	 */
	private Long createUser;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;

}
