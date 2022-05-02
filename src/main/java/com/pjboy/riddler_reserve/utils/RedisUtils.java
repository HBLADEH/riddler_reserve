package com.pjboy.riddler_reserve.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtils {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    public void del(String... key) {
        redisTemplate.delete(key[0]);
    }

    /**
     * 计数
     *
     * @param key
     * @param value
     */
    public Long add(String key, Object... value) {
        return redisTemplate.opsForHyperLogLog().add(key, value);
    }

    /**
     * 获取总数
     *
     * @param key
     */
    public Long size(String key) {
        return redisTemplate.opsForHyperLogLog().size(key);
    }

}