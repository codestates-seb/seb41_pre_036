package com.codestates.preproject.config;
import com.codestates.preproject.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    MemberService memberService;

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/css/, /static/js/, *.ico");

        // swagger
        web.ignoring().antMatchers(
                "/v2/api-docs",  "/configuration/ui",
                "/swagger-resources", "/configuration/security",
                "/swagger-ui.html", "/webjars/","/swagger/");
    }

    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/user/admin/").access("hasAuthority('ADMIN')")
                .antMatchers("/user/info").access("hasAuthority('USER')")
                .antMatchers("/", "/user/signup", "/user/denied", "/user/logout/result").permitAll()
                .antMatchers("/swagger-resources/").permitAll() // swagger
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/user/loginPage")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/user/login/result")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/logout/result")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/user/denied")
        ;

    }
}