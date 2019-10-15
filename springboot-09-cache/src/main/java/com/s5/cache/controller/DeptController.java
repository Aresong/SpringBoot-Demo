package com.s5.cache.controller;

import com.s5.cache.bean.Department;
import com.s5.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Aresong
 * @Date: 2019/6/26 22:31
 * @Version 1.0
 */

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable Integer id){
        return deptService.getDeptById(id);
    }

}
