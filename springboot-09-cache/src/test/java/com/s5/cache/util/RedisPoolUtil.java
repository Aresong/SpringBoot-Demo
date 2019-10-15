package com.s5.cache.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: Aresong
 * @Date: 2019/6/19 23:51
 * @Version 1.0
 */

//什么也不配也有默认值
public class RedisPoolUtil {

    private static String host = "127.0.0.1";
    private static int port = 6379;
    private static JedisPool pool;

    static{
        //1创建连接池Redis POOL 基本信息配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(5);//最大连接数
        poolConfig.setMaxIdle(1);//最大空闲数
        //2连接池
        pool = new JedisPool(poolConfig,host,port);
    }
    //从连接池中获取Jedis
    public static Jedis getJedis(){
        Jedis jedis = pool.getResource();
        return jedis;
    }
    //关闭Jedis
    public static void closeJedis(Jedis jedis){
        jedis.close();
    }
}
