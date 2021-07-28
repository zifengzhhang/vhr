package com.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    /**
     *
     * @param authentication  表示当前登录的用户
     * @param object
     * @param configAttributes     所需要的角色
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 遍历返回后需要的角色
        for (ConfigAttribute attribute : configAttributes) {
            if ("ROLE_LOGIN".equals(attribute.getAttribute())) {
                // 路径未匹配成功，需要登录后才能访问
                // 判断用户是否登录
                if (authentication instanceof AnonymousAuthenticationToken) {
                    // 用户未登录
                    throw new AccessDeniedException("尚未登录，请登录");
                } else {
                    // 用户已经登录，退出
                    return;
                }
            }

            // 获取当前用户所拥有的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                // 判断是否存在所需要的角色
                if (authority.getAuthority().equals(attribute.getAttribute())) {
                    // 已拥有所需要的角色, 退出
                    return;
                }
            }
        }

        throw new AccessDeniedException("权限不足，请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
