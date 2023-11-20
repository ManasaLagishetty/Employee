package com.evoke.employee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf-> csrf.disable())
//        .authorizeHttpRequests((requests) ->requests
//                .requestMatchers("/home").authenticated()
//                .requestMatchers("/address","/employee","/login").permitAll()
//                .anyRequest().authenticated()
//        );
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//        return (SecurityFilterChain)http.build();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(requests->requests.requestMatchers("/login","/message","/log").permitAll()
                        .anyRequest().authenticated())
                       .exceptionHandling(ex->ex.authenticationEntryPoint(jwtAuthenticationEntryPoint));
                     http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
//
//       @Bean
//       public InMemoryUserDetailsManager userDetailService(){
//        UserDetails user= User.withDefaultPasswordEncoder().username("Manasa").password("Password").build();
//        UserDetails user2= User.withDefaultPasswordEncoder().username("Rajasekhar").password("Password").build();
//        return new InMemoryUserDetailsManager(user,user2);
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

