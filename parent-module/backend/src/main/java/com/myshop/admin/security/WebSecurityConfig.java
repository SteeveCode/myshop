package com.myshop.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyshopUserDetailsService();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
        authprovider.setUserDetailsService(userDetailsService());
        authprovider.setPasswordEncoder((passwordEncoder()));
        return authprovider;
    }

    @Bean
    protected SecurityFilterChain  filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/states/list_by_country/**").hasAnyAuthority("Admin", "Salesperson")
                .requestMatchers("/users/**", "/settings/**", "/countries/**", "/states/**").hasAuthority("Admin")
                .requestMatchers("/categories/**", "/brands/**").hasAnyAuthority("Admin", "Editor")
                .requestMatchers("/products/new", "/products/delete/**").hasAnyAuthority("Admin", "Editor")

                .requestMatchers("/products/edit/**", "/products/save", "/products/check_unique")
                .hasAnyAuthority("Admin", "Editor", "Salesperson")

                .requestMatchers("/products", "/products/", "/products/detail/**", "/products/page/**")
                .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")

                .requestMatchers("/products/**").hasAnyAuthority("Admin", "Editor")
                .requestMatchers("/orders", "/orders/", "/orders/page/**", "/orders/detail/**").hasAnyAuthority("Admin", "Salesperson", "Shipper")
                .requestMatchers("/customers/**", "/orders/**", "/get_shipping_cost").hasAnyAuthority("Admin", "Salesperson")
                .requestMatchers("/orders_shipper/update/**").hasAuthority("Shipper")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .and().logout().permitAll()
                .and().rememberMe().key("AbcDefgHijklmnopqrs_1234567890")
        //restarting the server will not require login again because a new remember-me key is not created because
        // we used the key() method and specified a key in addition to the rememberMe() method
                .tokenValiditySeconds(3*24*60*60);
        http.headers().frameOptions().sameOrigin(); // permits content of iframe modal dialog to be displayed

        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }


}
