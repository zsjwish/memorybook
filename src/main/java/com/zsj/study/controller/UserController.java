package com.zsj.study.controller;

import com.zsj.study.model.User;
import com.zsj.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * created by zsj in 21:11 2018/8/8
 * description:
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/adduser")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        if (userService.getUserByName(user.getName())==null) {
            return userService.addUser(user);
        }
        return String.format("用户%s已存在",user.getName());
    }

    @GetMapping(value = "/username")
    @ResponseBody
    public String getUserByName(String name) {
        return userService.getUserByName(name).toString();
    }

    @GetMapping(value = "/useremail")
    @ResponseBody
    public String getUserByEmail(String email) {
        return userService.getUserByEmail(email).toString();
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public String getUserByName2(@RequestHeader String name) {
        return userService.getUserByName(name).toString();
    }

}
