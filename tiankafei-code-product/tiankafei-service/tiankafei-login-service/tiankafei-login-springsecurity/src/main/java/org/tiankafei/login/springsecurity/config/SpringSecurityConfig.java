package org.tiankafei.login.springsecurity.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author 魏双双
 * @since 1.0
 **/
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 基于内存存储多用户
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("admin1234")
//                .roles("admin")
//                .and()
//                .withUser("admin123")
//                .password("admin123")
//                .roles("xxoo")
//                .and();
//    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        可以忽略静态请求，可以忽略动态请求
//        web.ignoring().antMatchers("/img/**");
        web.ignoring().antMatchers("/encryption/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        User user = new User("admin", new BCryptPasswordEncoder().encode("admin1234"), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("admin")));
        manager.createUser(user);
        manager.createUser(User.withUsername("admin123").password(new BCryptPasswordEncoder().encode("admin123")).roles("xxoo").build());
        return manager;
    }

}
