package com.poly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
public class SecurityConfig {

	 private final UserDetailsService customUserDetailsService;

	    public SecurityConfig(UserDetailsService customUserDetailsService) {
	        this.customUserDetailsService = customUserDetailsService;
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public SpringSecurityDialect securityDialect() {
	        return new SpringSecurityDialect();
	    }

	    @Bean
	    public AuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(customUserDetailsService);
	        provider.setPasswordEncoder(passwordEncoder());
	        return provider;
	    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/homeuser/seat/**").authenticated()
                .requestMatchers("/homeuser", "/homeuser/login/**", "/homeuser/signup","/homeuser/html/login","/homeuser/add", "/site/oauth2/login/success").permitAll()
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/admin/**").hasAnyAuthority("Admin", "Staff")
                .requestMatchers("/site/**").hasAnyAuthority("Customer", "Staff")
                .anyRequest().authenticated())
            .formLogin(formLogin -> formLogin
                .loginPage("/homeuser/login").defaultSuccessUrl("/homeuser", true).failureUrl("/homeuser/login").permitAll())
            .logout(logout -> logout
                .logoutUrl("/site/logout")
                .logoutSuccessUrl("/login?logout").permitAll());
        return http.build();
    }
}
