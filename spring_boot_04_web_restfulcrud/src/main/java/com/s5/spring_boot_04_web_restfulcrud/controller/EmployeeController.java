package com.s5.spring_boot_04_web_restfulcrud.controller;

import com.s5.spring_boot_04_web_restfulcrud.dao.DepartmentDao;
import com.s5.spring_boot_04_web_restfulcrud.dao.EmployeeDao;
import com.s5.spring_boot_04_web_restfulcrud.entities.Department;
import com.s5.spring_boot_04_web_restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @Author: Aresong
 * @Date: 2019/4/15 21:32
 * @Version 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf默认自动拼串
        //classpath:/template/list
        return "emp/list";
    }

    //来到与员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查处所有的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        //来到添加页面
        return "emp/add";
    }

    //来到与员工添加页面
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //forward:转发到一个地址
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //来到员工修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //回到修改页面
        return "emp/add";
    }
}
