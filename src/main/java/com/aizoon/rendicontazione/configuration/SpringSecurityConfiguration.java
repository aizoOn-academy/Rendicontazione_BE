package com.aizoon.rendicontazione.configuration;

import com.aizoon.rendicontazione.filters.JsonAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfiguration {
    private final String currentProfile;

    public SpringSecurityConfiguration(@Value("${spring.profiles.active}") String currentProfile) {
        this.currentProfile = currentProfile;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JsonAuthenticationFilter jsonAuthenticationFilter) throws Exception {
        if("dev".equals(currentProfile)) {
            http.cors().and().csrf().disable();
        }

        http.authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .anyRequest().authenticated();

        //Adding logout capabilities
        http.logout( customizer -> {
            AntPathRequestMatcher logoutMatcher = new AntPathRequestMatcher("/api/logout", "POST");
            
            customizer.logoutRequestMatcher(logoutMatcher);
            customizer.deleteCookies("JSESSIONID");
            customizer.defaultLogoutSuccessHandlerFor(new HttpStatusReturningLogoutSuccessHandler(), logoutMatcher);
        });

        //Replacing the default authentication filter (It was using parameters in the request to authenticate)
        http.addFilter(jsonAuthenticationFilter);

        http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.FORBIDDEN));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JsonAuthenticationFilter jsonAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationFailureHandler authenticationFailureHandler, AuthenticationSuccessHandler authenticationSuccessHandler) {
        JsonAuthenticationFilter filter = new JsonAuthenticationFilter();
        filter.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/api/login", "POST")
        );

        filter.setAuthenticationManager(authenticationManager);
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailureHandler);

        return filter;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
