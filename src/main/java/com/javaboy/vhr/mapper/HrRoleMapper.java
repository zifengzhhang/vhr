package com.javaboy.vhr.mapper;

import com.javaboy.vhr.pojo.HrRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    void deleteHrRole(Integer hrid);

    Integer addHrRoles(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}