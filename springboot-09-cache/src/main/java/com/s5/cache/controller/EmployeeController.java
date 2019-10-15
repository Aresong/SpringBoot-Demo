package com.s5.cache.controller;

import com.s5.cache.bean.Employee;
import com.s5.cache.service.EmployeeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Aresong
 * @Date: 2019/6/10 22:20
 * @Version 1.0
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/del/{id}")
    public String delte(@PathVariable Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
