package com.s5.springboot.repository;

import com.s5.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author: Aresong
 * @Date: 2019/5/20 23:01
 * @Version 1.0
 */
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer> {
}
