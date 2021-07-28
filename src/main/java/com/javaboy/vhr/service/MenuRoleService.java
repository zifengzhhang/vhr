package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.MenuRoleMapper;
import com.javaboy.vhr.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuRoleService {

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Integer> getMidByRid(Integer rid) {
        return menuRoleMapper.getMidByRid(rid);
    }

    @Transactional
    public Boolean updateMenuRole(Integer rid, Integer[] mids) {
        // 先将角色所拥有的权限删除
        menuRoleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        // 在把角色修改后选中的权限添加
        return menuRoleMapper.insertMenus(rid, mids) == mids.length;
    }

}
