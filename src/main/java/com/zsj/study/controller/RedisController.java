package com.zsj.study.controller;

import com.zsj.study.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * created by zsj in 0:18 2018/8/10
 * description:
 **/
@Controller
public class RedisController {
    @Autowired
    RedisService redisService;

    @PostMapping(value = "/addonedata")
    @ResponseBody
    public String addOneData(String listName, String value) {
        return redisService.pushList(listName, value);
    }

    @GetMapping(value = "/getdata")
    @ResponseBody
    public String getData(String listName) {
        StringBuilder sb = new StringBuilder(listName+"\n");
        List<String> list = redisService.getListByListName(listName);
        for (String tmp : list) {
            sb.append(tmp + "\n");
        }
        return sb.toString();
    }


}
