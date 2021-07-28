package com.javaboy.vhr.mapper;

import com.javaboy.vhr.pojo.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusById(Integer hrid);

    List<Menu> getAllMenusWithRole();
}