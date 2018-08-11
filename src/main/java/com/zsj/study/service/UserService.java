package com.zsj.study.service;

import com.zsj.study.dao.UserDao;
import com.zsj.study.model.LoginTicket;
import com.zsj.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by zsj in 21:08 2018/8/8
 * description:
 **/
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    LoginTicket loginTicket;

    public String addUser(User user) {
        userDao.save(user);
        return user.toString();
    }

    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public void deleteUserByEmail(String email) {
        userDao.deleteByEmail(email);
    }


}
