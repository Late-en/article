package com.example.article.controller;

import com.example.article.entity.Article;
import com.example.article.model.ApiResponse;
import com.example.article.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Late-en
 */

@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	/**
	 * 用户注册
	 */
	@PostMapping("/add")
	public ApiResponse addArticle(@RequestBody Article article){
		if(!articleService.addArticle(article)){
			return ApiResponse.ofError("用户创建失败");
		}
		return ApiResponse.ofSuccess("注册成功", articleService.getArticleInfo(article.getId()));
	}


	/**
	 * 返回所有
	 */
	@GetMapping("")
	public ApiResponse allArticle() {
		return ApiResponse.ofSuccess("所有用户信息返回成功", articleService.AllArticle());
	}


	/**
	 * 查找
	 */
	@PostMapping(value = "/search")
	public ApiResponse Search(@RequestBody Article example,@RequestParam Integer page, @RequestParam Integer limit){
		log.debug(String.valueOf(example));
		List<Article> result = articleService.searchArticle(example);
		if (result != null){
			return ApiResponse.ofSuccess("ok",result);
		}
		return ApiResponse.ofError("error");
	}

	/**
	 * 更新信息数据
	 */
	@PostMapping("/update")
	public ApiResponse updateArticleInfo(@RequestBody Article article){
		if(!articleService.updateArticleInfo(article)){
			return ApiResponse.ofError("修改失败");
		}
		return ApiResponse.ofSuccess("修改成功");
	}


	/**
	 * 删除
	 */
	@GetMapping("/delete")
	public ApiResponse deleteArticle(@RequestParam Long id){
		if(articleService.deleteArticle(id)){
			return ApiResponse.ofSuccess("删除成功");
		} else return ApiResponse.ofError("删除失败");
	}
}