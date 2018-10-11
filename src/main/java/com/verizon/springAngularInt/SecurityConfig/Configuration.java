package com.verizon.springAngularInt.SecurityConfig;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@org.springframework.context.annotation.Configuration
public class Configuration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
        .withUser("abcd").password("pass123").roles("USER")
        .and()
        .withUser("pqrs").password("pass123").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/").permitAll()
	      .and()
	      .authorizeRequests().antMatchers("/getall").hasAnyRole("USER","ADMIN")
	      .and()
	      .authorizeRequests().antMatchers("/create").hasAnyRole("ADMIN")
	      .and()
	      .authorizeRequests().antMatchers("/delete/{id}").hasAnyRole("ADMIN")
	      .and()  
	      .formLogin()
	      .and()
	      .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	
}
