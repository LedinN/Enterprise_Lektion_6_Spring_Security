package com.nick.enterprise_lektion_6_spring_security.config;

import com.nick.enterprise_lektion_6_spring_security.authorities.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/login", "/api/**").permitAll()
                    .requestMatchers("/admin").hasRole(UserRole.ADMIN.name())
                    .requestMatchers("/user").hasRole(UserRole.USER.name()) //.hasAuthority alternativ, UserPermission.DELETE.getPermission()
                    .anyRequest()
                    .authenticated()
            )
            .formLogin(Customizer.withDefaults());

    return http.build();

    }


    //DEBUG USER
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("nick")
                .password("hej")
                .authorities(UserRole.USER.getAuthorities())
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
