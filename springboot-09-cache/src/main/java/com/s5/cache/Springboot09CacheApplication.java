package com.s5.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.s5.cache.mapper")
@SpringBootApplication
//@EnableCaching开启基于注解的缓存
@EnableCaching
/**
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache;将数据保存在ConcurrentMap<Object,Object>
 *  开发中使用缓存中间件：redis、memcached、ehcache等 ；
 *  整合redis作为缓存，
 *  1.安装redis，使用docker
 *  2.引入redis的starter
 *  3.配置redis
 *  4.测试缓存
 *      原理CacheManager===Cache 缓存组件来实际给缓存中存取数据
 *      1）引入redis的starter，容器中保存的是RedisCacheManager
 *      2）RedisCacheManager帮我们创建RedisCache来作为缓存组件；RedisCache通过操作Redis缓存数据
 *      3）默认保存数据k-v都是Object；利用序列化保存；如何保存为json
 *          1.引入了redis的starter，cacheManager变为 RedisCacheManager；
 *          2.默认创建的 RedisCacheManager 操作redis的时候使用的是RedisTemplate<Object,Object>
 *          3.RedisTemplate<Object,Object> 是 默认使用jdk的序列化机制
 *      4）自定义CacheManager（写在MyRedisConfig里面了）；
 * **/
public class Springboot09CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09CacheApplication.class, args);
    }

}
