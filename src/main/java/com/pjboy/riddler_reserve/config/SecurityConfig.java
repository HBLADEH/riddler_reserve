package com.pjboy.riddler_reserve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: dqnetmusic
 * @description: Spring Security 配置
 * @author: BLADE
 * @create: 2021-02-10 18:29
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public BCryptPasswordEncoder bcryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }



  /*
    	authorizeRequests：所有security全注解配置实现的开端，表示开始说明需要的权限
	需要的权限分为两部分，第一部分是拦截的路径，第二部分是访问该路径需要的权限

	antMatchers  拦截的路径  permitAll()所有权限都可以，直接放行所有 hasAnyRole()这个方法可以指定角色
	anyRequest任何请求	 authenticated需要认证后才能访问

	.and().csrf().disable(); 固定写法   使防御 csrf 攻击失效，
	如果不设置为disabled，所有除了内部的请求，其余外部请求都被认为是在攻击我这个网站，全部拦截

	*/
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated()
            .and().csrf().disable();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    //解决静态资源被拦截的问题
    web.ignoring().antMatchers("/static/**");
  }
}
