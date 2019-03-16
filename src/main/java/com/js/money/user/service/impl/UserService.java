package com.js.money.user.service.impl;

import com.js.money.user.dao.IUserDao;
import com.js.money.user.entity.User;
import com.js.money.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Id;
import java.util.List;

@Service("userService")
public class UserService implements IUserService {
    @Resource
    private IUserDao userDao;
    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    public User getUserById(long userId) {
        return userDao.findUserByUserId(userId);
    }
}
