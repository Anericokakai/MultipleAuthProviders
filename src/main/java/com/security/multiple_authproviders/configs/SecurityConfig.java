package com.security.multiple_authproviders.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity

public class SecurityConfig {
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return  http
                .authorizeHttpRequests(req->req.anyRequest().authenticated()
                )

                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)

                .build();



    }

    @Bean
  public   UserDetailsService userDetailsService(){
        var u=  new InMemoryUserDetailsManager();

        var user1= User.withUsername("rico")
                .password(passwordEncoder().encode("1234"))
                .authorities("read").build();
         u.createUser(user1);
        var user2= User.withUsername("misiko")
                .password(passwordEncoder().encode("1234"))
                .authorities("write").build();
        u.createUser(user2);
         return  u;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
