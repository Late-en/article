package com.example.article.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
public class Article implements Serializable {

	private static final long serialVersionUID =  1L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "category_id")
	private Category category;

	/**
	 * 创建人ID
	 */
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.REFRESH)
	@JoinColumn(name = "create_user")
	private User createUser;

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
