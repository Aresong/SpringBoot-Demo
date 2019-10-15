package com.s5.cache;

import com.s5.cache.bean.Employee;
import com.s5.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot09CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    /**专门单独抽取出来，简化操作用的，操作k-v都是字符串**/
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    /**k-v都是对象的**/
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    @Test
    public void contextLoads() {

        Employee empById = employeeMapper.getById(1);
        System.out.println(empById);

    }
    /**
     * String（字符串）、list（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue();//[String字符串]
     *  stringRedisTemplate.opsForList();//[列表]
     *  stringRedisTemplate.opsForHash();//[散列]
     *  stringRedisTemplate.opsForSet();//[集合]
     *  stringRedisTemplate.opsForZSet();//[有序集合]
     * **/
    @Test
    public void test01(){
        //给redis中保存了一个数据
//        stringRedisTemplate.opsForValue().append("msg","hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);

//        stringRedisTemplate.opsForList().leftPush("mylist","1");
//        stringRedisTemplate.opsForList().leftPush("mylist","2");

    }

    //测试保存对象
    @Test
    public void test02(){
        Employee empById = employeeMapper.getById(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//        redisTemplate.opsForValue().set("emp-01",empById);
        //1.将数据以json的方式保存
        //(1)自己转json
        //(2)redisTemplate默认的序列化规则,改变默认的序列化规则
        empRedisTemplate.opsForValue().set("emp-02",empById);
    }
}
