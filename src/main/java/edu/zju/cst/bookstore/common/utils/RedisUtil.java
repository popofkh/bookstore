package edu.zju.cst.bookstore.common.utils;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisUtil {
    /**
     * redis过期时间,以秒为单位
     */
    public final static int EXRPIRE_MINUTE = 60;               // 一分钟
    public final static int EXRPIRE_HOUR = 60 * 60;            //一小时
    public final static int EXRPIRE_HALF_DAY = 60 * 60 * 12;   //半天
    public final static int EXRPIRE_DAY = 60 * 60 * 24;        //一天
    public final static int EXRPIRE_MONTH = 60 * 60 * 24 * 30; //一个月

    private static volatile JedisPool jedisPool = null;

    private RedisUtil() {
    }

    private static void initJedisPool() {
        if (null == jedisPool) {
            synchronized (RedisUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig, "localhost", 6379, 3000, "redis");
                }
            }
        }
    }

    public static void release(Jedis jedis) {
        if (null != jedis) {
            jedisPool.returnResourceObject(jedis);
        }
    }

    public static String getString(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(jedis);
        }
        return null;
    }

    /**
     * 设置String类型的值
     * @param key 键
     * @param value 值
     * @param expire 过期时间
     */
    public static void setString(String key, String value, int expire) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value, "NX", "EX", expire);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(jedis);
        }
    }

    public static void setString(String key, String value) {
        setString(key, value, -1);
    }

}