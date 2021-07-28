package com.javaboy.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaboy.vhr.pojo.Hr;
import com.javaboy.vhr.pojo.RespBean;
import com.javaboy.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;
    @Autowired
    CustomAccessDecisionManager customAccessDecisionManager;
    @Autowired
    CustomFilterInvocation customFilterInvocation;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.anyRequest().authenticated()  //所有资源都需要经过认证后访问
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customAccessDecisionManager);
                        object.setSecurityMetadataSource(customFilterInvocation);
                        return object;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .loginPage("/login")
                // 登录成功后的回调
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        // 获取登录后的用户身份信息
                        Hr hr = (Hr) authentication.getPrincipal();
                        // 在返回给前端json时不应将密码返回，设置为空
                        hr.setPassword(null);
                        RespBean success = RespBean.success("登录成功", hr);

                        out.write(new ObjectMapper().writeValueAsString(success));
                        out.flush();
                        out.close();
                    }
                })

                // 登录失败后的回调
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        RespBean fail = RespBean.fail("登录失败");
                        if (e instanceof LockedException) {
                            fail.setMsg("账户被锁定，请联系管理员!");
                        } else if (e instanceof DisabledException) {
                            fail.setMsg("账户被禁用，请联系管理员");
                        } else if (e instanceof CredentialsExpiredException) {
                            fail.setMsg("密码过期，请联系管理员");
                        } else if (e instanceof AccountExpiredException) {
                            fail.setMsg("账户过期，请联系管理员");
                        } else if (e instanceof BadCredentialsException) {
                            fail.setMsg("用户名或密码错误，请重新登录");
                        }

                        out.write(new ObjectMapper().writeValueAsString(fail));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write(new ObjectMapper().writeValueAsString(RespBean.success("注销成功")));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        // 当保存用户信息session失效或过期时，返回401，让前端做跳转登录页面处理
                        httpServletResponse.setStatus(401);
                        PrintWriter out = httpServletResponse.getWriter();
                        RespBean fail = RespBean.fail("访问失败!");
                        if (e instanceof InsufficientAuthenticationException) {
                            fail.setMsg("请求失败，请登录");
                        }

                        out.write(new ObjectMapper().writeValueAsString(fail));
                        out.flush();
                        out.close();
                    }
                });
    }
}
