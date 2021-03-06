package com.Wang.Demo;

import com.Wang.Util.RedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/**
 * @author Wangdong
 * @date 2019/11/28 - 下午7:19
 */
public class RedisDemo {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6379;
        Jedis jedis = new Jedis(host,port);
        jedis.auth("root");
        System.out.printf(jedis.ping());

    }
    @Test
    public void t1(){
        //get connect
        Jedis jedis = RedisPoolUtil.getJedis();
        jedis.set("strName","字符串的名称");
        String strName = jedis.get("strName");
        System.out.printf("Redis的数据:"+strName);
        RedisPoolUtil.close(jedis);
    }
    @Test
    public void t2(){
        //get connect redis
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("root");
        String key = "applicationName";
        if(jedis.exists(key)){
            String result = jedis.get(key);
            System.out.printf("Redis database check result:"+result);
        }else {
            //databae check
            String result  = "wechat";
            jedis.set(key,result);
            System.out.printf("Mysql database check result:"+result);
        }
    jedis.close();
    }
    @Test
    public void t3(){
        //获得链接
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("root");
        String key = "code:18841745022";
        if(jedis.exists(key)){

            String result = jedis.get(key);
            System.out.printf("Redis数据库中查询得到的验证码："+result);

        }else{
            String result = "微信开发会议达人";
            jedis.set(key,result);
            System.out.printf("从MySQL数据库中查询得到的："+result);
        }

    }
    /**
     * Jedis 完成对Hash类型操作
     * 需求：hash存储一个对象
     * 判断Redis中是否存在该key，如果存在，直接返回对应值
     * 如果不存在，查询数据库，（将查询的结果存入redis）并返回给用户
     */



}
