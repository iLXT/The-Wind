package com.stuwxq.config;

import com.stuwxq.security.MyAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



/**
 * @auther Wangxq
 * @date2021/2/1219:40
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Qualifier("userDetailServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/admin/toLogin")
                .loginProcessingUrl("/admin/login")
                .successForwardUrl("/admin/toMain");
        http.authorizeRequests()
                .antMatchers("/admin/toLogin").permitAll()
                .antMatchers("/admin/**").authenticated();
        http.exceptionHandling().authenticationEntryPoint(myAuthenticationEntryPoint);
        http.csrf().disable();
        http.logout()
                //清除session对象，清除认证对象
                //退出登录url
                .logoutUrl("/admin/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                //退出登录跳转的url
                .logoutSuccessUrl("/admin/toLogin");

    }
    @Bean
    public PasswordEncoder pE(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(pE());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        .antMatchers("/static/**");
    }


}
