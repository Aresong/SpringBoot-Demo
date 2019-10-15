package com.s5.springboot.controller;

import com.s5.springboot.bean.Department;
import com.s5.springboot.bean.Employee;
import com.s5.springboot.mapper.DepartmentMapper;
import com.s5.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Aresong
 * @Date: 2019/5/15 23:37
 * @Version 1.0
 */
@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDeptment(Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public  Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return  department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
