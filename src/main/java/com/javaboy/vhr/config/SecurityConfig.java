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
                //.anyRequest().authenticated()  //??????????????????????????????????????????
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
                // ????????????????????????
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        // ????????????????????????????????????
                        Hr hr = (Hr) authentication.getPrincipal();
                        // ??????????????????json???????????????????????????????????????
                        hr.setPassword(null);
                        RespBean success = RespBean.success("????????????", hr);

                        out.write(new ObjectMapper().writeValueAsString(success));
                        out.flush();
                        out.close();
                    }
                })

                // ????????????????????????
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        RespBean fail = RespBean.fail("????????????");
                        if (e instanceof LockedException) {
                            fail.setMsg("????????????????????????????????????!");
                        } else if (e instanceof DisabledException) {
                            fail.setMsg("????????????????????????????????????");
                        } else if (e instanceof CredentialsExpiredException) {
                            fail.setMsg("?????????????????????????????????");
                        } else if (e instanceof AccountExpiredException) {
                            fail.setMsg("?????????????????????????????????");
                        } else if (e instanceof BadCredentialsException) {
                            fail.setMsg("??????????????????????????????????????????");
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
                        out.write(new ObjectMapper().writeValueAsString(RespBean.success("????????????")));
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
                        // ?????????????????????session???????????????????????????401???????????????????????????????????????
                        httpServletResponse.setStatus(401);
                        PrintWriter out = httpServletResponse.getWriter();
                        RespBean fail = RespBean.fail("????????????!");
                        if (e instanceof InsufficientAuthenticationException) {
                            fail.setMsg("????????????????????????");
                        }

                        out.write(new ObjectMapper().writeValueAsString(fail));
                        out.flush();
                        out.close();
                    }
                });
    }
}
