package com.example.web_hospital_patient_card.SecurityConfig.AppSecurityConfig;

import com.example.web_hospital_patient_card.Models.roles.Role;
import com.example.web_hospital_patient_card.SecurityConfig.Encoder.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class AppSecurityConfigClass extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    @Qualifier("BCryptEncoder")
    private PasswordEncoder passwordEncoder;


    @Override
    @Profile("application_prod")//need to be updated
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/admin/**","/admin_service/**").hasAuthority(Role.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/getLoginPage")
                .permitAll()
                .defaultSuccessUrl("/user/user_data")
                .failureForwardUrl("/getLoginPage");
    }

    @Bean
    @Profile("application_prod")
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(appUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder.getBCryptEncoder());
        return daoAuthenticationProvider;

    }


    @Bean
    @Profile("application_test")
    public AuthenticationProvider authenticationProviderTest() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(
                new InMemoryUserDetailsManager(List.of(
                        User.builder().username("Andrew").password(passwordEncoder.getBCryptEncoder().encode("123")).roles("ADMIN").disabled(true).build(),
                        User.builder().username("Kira").password(passwordEncoder.getBCryptEncoder().encode("123")).roles("ADMIN").disabled(false).build(),
                        User.builder().username("Taras").password(passwordEncoder.getBCryptEncoder().encode("123")).roles("DOCTOR").disabled(false).build(),
                        User.builder().username("Inna").password(passwordEncoder.getBCryptEncoder().encode("123")).roles("USER").disabled(false).build()
                )));
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder.getBCryptEncoder());
        return daoAuthenticationProvider;

    }
}
