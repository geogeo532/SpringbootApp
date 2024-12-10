package com.aplicatie.Corbeanu_George_java_app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(customizer -> customizer.disable())
                .authorizeRequests(request ->
                        request.requestMatchers("/admin/api/clasament/**").authenticated()
                                .requestMatchers("/admin/api/echipa/**").authenticated()
                                .requestMatchers("/admin/api/jucator/**").authenticated()
                                .requestMatchers("/admin/api/meci/**").authenticated()
                                .requestMatchers("/admin/api/sponsor/**").authenticated()
                                .requestMatchers("/admin/api/sponsorEchipe/**").authenticated()
                                .requestMatchers("/admin/api/stadion/**").authenticated()
                                .requestMatchers("/admin/api/statisticaEchipe/**").authenticated()
                                .requestMatchers("/admin/api/statisticaJucatori/**").authenticated()
                                .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password("{noop}parola") // Prefixăm parola cu {noop}
                        .roles("USER")
                        .build()
        );
    }


}

