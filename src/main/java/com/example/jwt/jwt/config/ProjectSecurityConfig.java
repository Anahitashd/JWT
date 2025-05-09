package com.example.jwt.jwt.config;

import com.example.jwt.jwt.exceptionhandling.CustomAccessDeniedHandler;
import com.example.jwt.jwt.exceptionhandling.CustomBasicAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import javax.sql.DataSource;

@Configuration
@Profile("!prod")
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement((smc -> smc.invalidSessionUrl("/invalidSession").maximumSessions(3).maxSessionsPreventsLogin(true)))
                .requiresChannel(rcc -> rcc.anyRequest().requiresInsecure()) // Only HTTP
                .csrf(csrfConfig -> csrfConfig.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("myAccount", "myBalance", "myLoans", "myCards").authenticated()
                        .requestMatchers("/notices", "/contact", "error", "/register","invalidSession").permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(hbc -> hbc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        http.exceptionHandling(ehc -> ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));
        return (SecurityFilterChain) http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

//        For saving in memory
//        UserDetails user= User.withUsername("user")
//                .password("{noop}AnahitaShd@12345")
//                .authorities("read").build();
//        UserDetails admin= User.withUsername("admin")
//                .password("{bcrypt}$2a$12$gCbKELf3hdvIo6CeKR8JZ.xwXXfgn4gig1y8eT9SgCGL0bpN6zw4m")
//                .authorities("admin").build();

        return new JdbcUserDetailsManager(dataSource);
    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}
