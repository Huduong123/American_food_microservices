package com.american_food.api_ckt3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        return userDetailsManager;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // hoặc NoOpPasswordEncoder.getInstance() nếu bạn chưa mã hóa
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->configurer

                .requestMatchers(HttpMethod.GET,"/api/system/users").hasRole("SYSTEM")
                .requestMatchers(HttpMethod.GET, "/api/system/users/**").hasRole("SYSTEM")
                .requestMatchers(HttpMethod.POST,"/api/system/users").hasRole("SYSTEM")
                .requestMatchers(HttpMethod.PUT,"/api/system/users").hasRole("SYSTEM")
                .requestMatchers(HttpMethod.DELETE,"/api/system/users").hasRole("SYSTEM")

                .requestMatchers(HttpMethod.GET, "api/system//authorities").hasRole("SYSTEM")
                .requestMatchers(HttpMethod.GET, "/api/system/authorities/**").hasRole("SYSTEM")
                .requestMatchers(HttpMethod.POST, "/api/system/authorities").hasRole("SYSTEM")
                .requestMatchers(HttpMethod.PUT, "/api/system/authorities").hasRole("SYSTEM")
                .requestMatchers(HttpMethod.DELETE, "/api/system/authorities").hasRole("SYSTEM")

                .requestMatchers(HttpMethod.GET, "/api/admin/products").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/admin/products/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/admin/products").hasAnyRole("ADMIN","SYSTEM")
                .requestMatchers(HttpMethod.PUT, "/api/admin/products").hasAnyRole("ADMIN","SYSTEM")
                .requestMatchers(HttpMethod.DELETE, "/api/admin/products").hasAnyRole("ADMIN","SYSTEM")

                .requestMatchers(HttpMethod.GET, "/api/admin/customers").hasAnyRole("ADMIN","SYSTEM")
                .requestMatchers(HttpMethod.GET, "/api/admin/customers/**").hasAnyRole("ADMIN","SYSTEM")
                .requestMatchers(HttpMethod.POST, "/api/admin/customers").hasAnyRole("ADMIN","SYSTEM")
                .requestMatchers(HttpMethod.PUT, "/api/admin/customers").hasAnyRole("ADMIN","SYSTEM")
                .requestMatchers(HttpMethod.DELETE, "/api/admin/customers").hasAnyRole("ADMIN","SYSTEM")

        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }


}
