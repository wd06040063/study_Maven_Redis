package com.Wang.Util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Wangdong
 * @date 2019/12/4 - 下午7:00
 */
public class RedisPoolUtil {
    private static JedisPool pool;
    static{
        //1 连接池Redis Pool 基本配置信息
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(5);
        poolConfig.setMaxIdle(1);
        String host = "127.0.0.1";
        int port = 6379;
        pool = new JedisPool(poolConfig,host,port);

    }
    public static Jedis getJedis(){
        Jedis jedis = pool.getResource();
        jedis.auth("root");
        return jedis;
    }
    //关闭redis
    public static void close(Jedis jedis){
        jedis.close();
    }
}
