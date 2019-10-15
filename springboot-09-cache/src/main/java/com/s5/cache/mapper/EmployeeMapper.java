package com.s5.cache.mapper;

import com.s5.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @Author: Aresong
 * @Date: 2019/6/10 22:04
 * @Version 1.0
 */
@Mapper
public interface EmployeeMapper {

    @Select("SELECT *FROM employee WHERE id=#{id}")
    public Employee getById(Integer Id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES (#(lastName),#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
