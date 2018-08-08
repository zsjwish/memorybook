package com.zsj.study.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * created by zsj in 23:42 2018/8/8
 * description:
 **/
@Service
public class JedisAdapter implements InitializingBean{

    private static final Logger logger = LoggerFactory.getLogger(JedisAdapter.class);

    private Jedis jedis = null;

    private JedisPool jedisPool = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        jedisPool = new JedisPool("localhost", 6379);
        logger.info("redis 已经启动,主机号：127.0.0.1,端口号：6379");
    }

    private Jedis getJedis() {
        return jedisPool.getResource();
    }

    //---------------------Redis String
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        }catch (Exception e) {
            logger.error("set异常" + e.getMessage());
        }
        finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        }catch (Exception e) {
            logger.error("get异常" + e.getMessage());
            return null;
        }
        finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
