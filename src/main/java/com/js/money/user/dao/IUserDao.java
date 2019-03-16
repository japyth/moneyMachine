package com.js.money.user.dao;

import com.js.money.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User,String> {
    User findUserByUserId(long userId);
}
