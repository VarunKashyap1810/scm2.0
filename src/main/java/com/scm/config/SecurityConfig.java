package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scm.services.UserServices;

@Configuration
public class SecurityConfig {

    @Autowired
    public UserServices userServices;

    /* @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1 = User
        .withDefaultPasswordEncoder()
        .username("admin123")
        .password("admin123")
        .roles("ADMIN","USER")
        .build();

        UserDetails user2 = User
        .withDefaultPasswordEncoder()
        .username("user123")
        .password("password")
        .build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,user2);
        return inMemoryUserDetailsManager; 
    } */

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(null);
        //password encoder object
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
