package com.javaboy.vhr.service;

import com.javaboy.vhr.mapper.MenuMapper;
import com.javaboy.vhr.pojo.Hr;
import com.javaboy.vhr.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenusById() {
        // 获取当前登录用户的id
        return menuMapper.getMenusById(((Hr) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).getId());
    }

    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
}
