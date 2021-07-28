package com.javaboy.vhr.mapper;

import com.javaboy.vhr.pojo.Menu;
import com.javaboy.vhr.pojo.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRoles();

    List<Menu> getAllMenus();
}