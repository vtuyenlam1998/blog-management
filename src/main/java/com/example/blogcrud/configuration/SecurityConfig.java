package com.example.blogcrud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Các tài nguyên tĩnh không cần xác thực
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll() // Các trang không cần xác thực
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/complain")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");
    }
}
