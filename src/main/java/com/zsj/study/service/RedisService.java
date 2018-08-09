package com.zsj.study.service;

import com.zsj.study.util.JedisAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * created by zsj in 23:52 2018/8/9
 * description:
 **/
@Service
public class RedisService {
    public static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    JedisAdapter jedisAdapter;

    public String pushList(String listName, String value) {
        if (listName.equals("") || listName == null || value.equals("")) {
            logger.error("插入失败，原因：描述为空或原因为空");
            return "插入失败，原因：listName为空";
        }
        Map<String, String> map = jedisAdapter.listPush(listName, value);
        if (map == null) {
            logger.error("插入数据失败！");
        }
        return String.format("成功插入一条数据,描述：%s,原因：%s", listName, value);
    }

    public List<String> getListByListName(String listName) {
        if (listName.equals("") || listName == null) {
            logger.error("描述为空");
            return null;
        }
        List<String> res = jedisAdapter.getListValue(listName);
        if (res.size() == 0 || res == null) {
            System.out.println("查询列表结果为空");
            logger.info("查询列表结果为空");
            return null;
        }
        return res;
    }
}
