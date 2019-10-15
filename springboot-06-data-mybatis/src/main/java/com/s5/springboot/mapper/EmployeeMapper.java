package com.s5.springboot.mapper;

import com.s5.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Aresong
 * @Date: 2019/5/16 23:02
 * @Version 1.0
 */

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

}
