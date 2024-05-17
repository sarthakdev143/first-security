package com.example.firstsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {
        @Bean
        @SuppressWarnings("deprecation")
        public InMemoryUserDetailsManager userDetailsService() {
                UserDetails user = User.withDefaultPasswordEncoder()
                                .username("sarthak-parulekar")
                                .password("1234")
                                .roles("USER")
                                .build();

                UserDetails user2 = User.withDefaultPasswordEncoder()
                                .username("user2")
                                .password("1234")
                                .roles("USER")
                                .build();

                UserDetails user3 = User.withDefaultPasswordEncoder()
                                .username("user3")
                                .password("1234")
                                .roles("ADMIN")
                                .build();
                return new InMemoryUserDetailsManager(user, user2, user3);
        }

        // @Bean
        // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //         http
        //                         .authorizeHttpRequests((requests) -> requests

        //                                         .requestMatchers("/sign-up/**").permitAll()
        //                                         .requestMatchers("/login/**").permitAll()
        //                                         .requestMatchers("/user/**").hasAnyRole("ADMIN", "USER")
        //                                         .requestMatchers("/admin/**").hasRole("ADMIN")
        //                                         .anyRequest().authenticated())

        //                         .formLogin((form) -> form
        //                                         .loginPage("/login")
        //                                         .loginProcessingUrl("/login")
        //                                         .defaultSuccessUrl("/", true)
        //                                         .permitAll())

        //                         .logout(obj -> obj.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        //                                         .logoutSuccessUrl("/")
        //                                         .invalidateHttpSession(true).deleteCookies("JESSIONID"));
        //         http.exceptionHandling((hi) -> hi.accessDeniedPage("/access-denied"));
        //         System.out.println("\n\nHello from Security Config\n\n");
        //         return http.build();
        // }

        // @Bean
        // public WebSecurityCustomizer webSecurityCustomizer() {
        //         return (web) -> web.ignoring().requestMatchers("/");
        // }
}