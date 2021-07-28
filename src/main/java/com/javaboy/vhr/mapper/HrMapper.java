package com.javaboy.vhr.mapper;

import com.javaboy.vhr.pojo.Hr;
import com.javaboy.vhr.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Hr> getAllHr(@Param("id") Integer id, @Param("keywords") String keywords);

    List<Role> getHrRoleById(Integer id);
}