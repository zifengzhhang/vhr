package com.javaboy.vhr.config;

import com.javaboy.vhr.pojo.Menu;
import com.javaboy.vhr.pojo.Role;
import com.javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomFilterInvocation implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;
    // 用于匹配路径
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取用户请求的路径
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> allMenusWithRole = menuService.getAllMenusWithRole();
        // 获取所有的路径规则
        for (Menu menu : allMenusWithRole) {
            // 判断是否正确匹配
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                // 获取访问该路径需要的角色
                List<Role> roles = menu.getRoles();
                String[] roleStr = new String[roles.size()];
                for (int i=0; i<roleStr.length; i++) {
                    roleStr[i] = roles.get(i).getName();
                }

                // 将需要的角色封装成ConfigAttribute对象返回
                return SecurityConfig.createList(roleStr);
            }
        }

        // ROLE_LOGIN表示需要登录后才能访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
