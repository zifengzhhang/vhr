package com.javaboy.vhr.mapper;

import com.javaboy.vhr.pojo.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartments(Integer parentId);

    void addDep(Department dep);

    void deleteDep(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}