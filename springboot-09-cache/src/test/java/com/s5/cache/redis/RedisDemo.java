package com.s5.cache.redis;

import com.s5.cache.util.RedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

/**
 * @Author: Aresong
 * @Date: 2019/6/19 23:17
 * @Version 1.0
 */
public class RedisDemo {
    private static String host = "127.0.0.1";
    private static int port = 6379;
    /**
     * Java端操作Jedis操作Redis服务器
     * 【linux上需要开端口号的】
     * **/
    public static void main(String[] args) {

        //1创建连接池Redis POOL 基本信息配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(5);//最大连接数
        poolConfig.setMaxIdle(1);//最大空闲数
        //...

        //2连接池
        JedisPool pool = new JedisPool(poolConfig,host,port);
        Jedis jedis = pool.getResource();

//        jedis.auth("PSPs5776371");//高版本redis使用，设置redis的密码
        System.out.println(jedis.ping());
    }

    /**
     * 测试字符串类型string
     * 【Redis中有哪些命令，Jedis中就有哪些方法!!!!!】
     * **/
    @Test
    public void t1(){
        //获得redis连接
        Jedis jedis = new Jedis(host,port);

        jedis.set("strName","字符串的名称");
        String name = jedis.get("strName");
        System.out.println(name);

        //关闭redis连接
        jedis.close();
    }

    /**
     * string
     * Redis作用：为了减轻数据库（MySql）的访问压力
     * 需求：判断某key是否存在，如果存在，就从Redis中查询
     * 如果不存在，就查询数据库，并将查询到的数据存入Redis
     * **/
    @Test
    public void t2(){
        //获得redis连接
        Jedis jedis = new Jedis(host,port);

        String key = "applicationName";//key的名称
        if(jedis.exists(key)){
            String result = jedis.get(key);
            System.out.println("Data from Redis:"+result);
        }else{
            //在数据库中查询
            String result = "模拟数据库查询出来的值";
            jedis.set("applicationName",result);
            System.out.println("从数据库中查询并写入Redis中：[key"+result+",value"+jedis.get(result)+"]");
        }

        //关闭redis连接
        jedis.close();
    }

    /**
     * 与t2一样，只不过使用了utils
     * **/
    public void t3(){
        //获得redis连接
        Jedis jedis = RedisPoolUtil.getJedis();

        String key = "applicationName";//key的名称
        if(jedis.exists(key)){
            String result = jedis.get(key);
            System.out.println("Data from Redis:"+result);
        }else{
            //在数据库中查询
            String result = "模拟数据库查询出来的值";
            jedis.set("applicationName",result);
            System.out.println("从数据库中查询并写入Redis中：[key"+result+",value"+jedis.get(result)+"]");
        }

        //关闭redis连接
        RedisPoolUtil.closeJedis(jedis);
    }

    /**
     * Jedis完成对Hash类型操作
     * 需求：hash存储一个对象
     *  判断Redis中是否存在该key，如果存在，直接返回对应值
     *  如果不存在，查询数据库（将查询结果存入redis）并返回给用户
     * **/
    @Test
    public void t4(){
        Jedis jedis = RedisPoolUtil.getJedis();
        String key = "users";
        if(jedis.exists(key)){
            Map<String,String> map = jedis.hgetAll(key);
            System.out.println("Redis中的显示结果--");
            System.out.println(map.get("id"));
        }else{
            //查询数据库并返回数据库
            jedis.hset(key,"id","1");
            jedis.hset(key,"name","scott");
            jedis.hset(key,"age","22");
            jedis.hset(key,"remark","11111");
        }
        RedisPoolUtil.closeJedis(jedis);
    }

}
