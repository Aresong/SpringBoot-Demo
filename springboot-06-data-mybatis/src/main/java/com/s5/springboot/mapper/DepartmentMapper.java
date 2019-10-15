package com.s5.springboot.mapper;

import com.s5.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @Author: Aresong
 * @Date: 2019/5/15 23:27
 * @Version 1.0
 */
//指定只是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}
