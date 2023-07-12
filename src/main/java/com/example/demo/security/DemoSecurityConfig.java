//package com.example.demo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DemoSecurityConfig {
//
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select email, password, active from users where email=?");
//
//        // define query to retrieve the authorities/roles by username
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select email, role from authority where email=?");
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE","ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE","ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/api/employees/new").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST,"/login").permitAll()
//
//        );
//
//
//        http.httpBasic(Customizer.withDefaults());
//
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//
//
//
//}
