package com.js.money.user.service;

import com.js.money.user.entity.User;

import java.util.List;

public interface IUserService {
    void saveUser(User user);
    List<User> getAllUser();
    User getUserById(long userId);
}
