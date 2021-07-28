package com.javaboy.vhr.mapper;

import com.javaboy.vhr.pojo.MenuRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    List<Integer> getMidByRid(Integer rid);

    void deleteByRid(Integer rid);

    Integer insertMenus(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}