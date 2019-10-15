package com.s5.springboot.bean;

/**
 * @Author: Aresong
 * @Date: 2019/5/15 0:34
 * @Version 1.0
 */
public class Department {
    private Integer id;
    private String  departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
