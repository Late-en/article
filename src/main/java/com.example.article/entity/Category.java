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
public class Category implements Serializable {

	private static final long serialVersionUID =  1L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@TableField(fill = INSERT)
	private Date createTime;

	/**
	 * 修改时间
	 */
	@TableField(fill = INSERT_UPDATE)
	private Date updateTime;

}
