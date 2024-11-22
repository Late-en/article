package com.example.article.service;

import com.example.article.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * @author Late-en
 */
public interface UserService {
    User getUserInfo(String username);

    boolean addUser(User user);

    boolean existUser(String username);

    boolean deleteUser(Serializable id);

    boolean updateUserInfo(User user);

    boolean updatePassword(User user);

    boolean verityPasswd(String username, String password);

    List<User> allUsers();
}
