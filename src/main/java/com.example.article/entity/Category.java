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
public class Category implements Serializable {

	private static final long serialVersionUID =  1L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 分类名称
	 */
	private String categoryName;

	/**
	 * 分类别名
	 */
	private String categoryAlias;

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
