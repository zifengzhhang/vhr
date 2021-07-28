package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.RoleMapper;
import com.javaboy.vhr.pojo.Menu;
import com.javaboy.vhr.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public List<Menu> getAllMenus() {
        return roleMapper.getAllMenus();
    }

    public int addRole(Role role) {
        // 当添加的角色名不符合规则时，手动添加前缀
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }

        return roleMapper.insertSelective(role);
    }

    public int deleteRoleById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
