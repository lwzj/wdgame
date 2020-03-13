package org.linlinjava.litemall.db.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /* 默认过期时长，单位：秒 */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /* 不设置过期时长 */
    public final static long NOT_EXPIRE = -1;
    public RedisUtils() {
    }

    public void set(String key, Object object) throws JsonProcessingException {
        set(key, object, DEFAULT_EXPIRE);
    }

    public void set(String key, Object object, long expire) throws JsonProcessingException {
    	ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        if (expire == NOT_EXPIRE) {
        	opsForValue.set(key, toJson(object));
        } else {
        	opsForValue.set(key, toJson(object), expire, TimeUnit.SECONDS);
        }
    }

    /* 获取指定类型的值  刷新生存时长 */
    public <T> T get(String key, Class<T> clazz, long expire)  {
    	ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String value = opsForValue.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    /* 获取指定类型的值  不刷新生存时长 */
    public <T> T get(String key, Class<T> clazz)  {
        return get(key, clazz, NOT_EXPIRE);
    }

    /* 获取String类型的值  刷新生存时长 */
    public String get(String key, long expire) {
    	ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String value = opsForValue.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    /* 获取String类型的值  不刷新生存时长 */
    public String get(String key) {
        return get(key,NOT_EXPIRE);
    }

    /* 删除 */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) throws JsonProcessingException {
        if (object instanceof Integer || object instanceof Long || object instanceof Float || object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        // ObjectMapper objectMapper = JacksonUtils.createObjectMapperNullNotEcho(null);
        return JSONUtils.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz)  {
        return JSONUtils.parseObject(json, clazz);
    }
}