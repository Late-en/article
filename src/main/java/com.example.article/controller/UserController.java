package com.example.article.controller;

import com.example.article.entity.User;
import com.example.article.model.ApiResponse;
import com.example.article.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Late-en
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 */
	@PostMapping("/add")
	public ApiResponse addUser(@RequestBody User User){
		String username = User.getUsername().trim();
		if(userService.existUser(username)){
			return ApiResponse.ofWarning("用户已存在");
		}
		if(!userService.addUser(User)){
			return ApiResponse.ofError("用户创建失败");
		}
		return ApiResponse.ofSuccess("注册成功", userService.getUserInfo(User.getUsername()));
	}


	/**
	 * 登陆校验
	 */
	@PostMapping("/login")
	public ApiResponse login(@RequestBody User user){
		if(userService.verityPasswd(user.getUsername(),user.getPassword())){
			return ApiResponse.ofSuccess("登陆成功", userService.getUserInfo(user.getUsername()));
		}
		return ApiResponse.ofWarning("用户名或密码错误");
	}

	/**
	 * 返回所有用户
	 */
	@GetMapping("")
	public ApiResponse allUsers() {
		return ApiResponse.ofSuccess("所有用户信息返回成功", userService.allUsers());
	}

	/**
	 * 根据id返回用户
	 */
	@GetMapping("/detail")
	public ApiResponse userOfId(@RequestParam String username){
		return ApiResponse.ofSuccess("用户"+username+"信息返回成功", userService.getUserInfo(username));
	}

	/**
	 * 更新用户信息数据
	 */
	@PostMapping("/update")
	public ApiResponse updateUserInfo(@RequestBody User User){
		if(!userService.existUser(User.getUsername())) User.setUsername(null);
		if(!userService.updateUserInfo(User)){
			return ApiResponse.ofError("用户修改失败");
		}
		return ApiResponse.ofSuccess("用户修改成功");
	}

	/**
	 * 更改用户密码
	 */
	@PostMapping("/update/password")
	public ApiResponse updateUserPassword(HttpServletRequest req){
		String username = req.getParameter("username").trim();
		String oldPassword = req.getParameter("oldPassword").trim();
		if(!userService.verityPasswd(username, oldPassword)){
			return ApiResponse.ofWarning("原始密码错误");
		}
		String password = req.getParameter("newPassword").trim();
		User user = User.builder().username(username).password(password).build();
		if(userService.updatePassword(user)){
			return ApiResponse.ofSuccess("密码修改成功");
		} else return ApiResponse.ofError("未知错误，密码修改失败");
	}

	/**
	 * 删除用户
	 */
	@GetMapping("/delete")
	public ApiResponse deleteUser(@RequestParam Long id){
		if(userService.deleteUser(id)){
			return ApiResponse.ofSuccess("用户删除成功");
		} else return ApiResponse.ofError("用户删除失败");
	}
}