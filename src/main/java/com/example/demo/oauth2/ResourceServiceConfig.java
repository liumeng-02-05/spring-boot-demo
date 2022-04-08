package com.example.demo.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import javax.annotation.Resource;

/**

 * @since 1.0.0
 */
@Configuration
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private UserAuthenticationEntryPoint userAuthenticationEntryPoint;

    @Resource
    private UserAccessDeniedHandler userAccessDeniedHandler;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("rid");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/home/**").permitAll();

        http.authorizeRequests()
                //.antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/admin/**").hasAnyRole("admin","ADMIN")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated();

        //access deny
            http.exceptionHandling().accessDeniedHandler(userAccessDeniedHandler);
        //unauthorized
        http.exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint);
    }
}