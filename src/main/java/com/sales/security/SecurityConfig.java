package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
* Security configuration for application.
* 
* @author Matthew Sloyan G00348036
*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	* Sets up security which only allows access to pages if user is logged inAlso allows logout functionality.
	*/
	@Override
	  public void configure(HttpSecurity httpSecurity) throws Exception{
	    httpSecurity.authorizeRequests()
	     .antMatchers("/addBook", "/editBook", "/addCustomer", "/editCustomer", "/newLoan", "/deleteLoan", 
	    		 "/showBooks", "/showCustomers", "/showLoans")
	     .hasRole("USER")
	     .and()
	     .formLogin()
	     .and()
	     .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	  }
	
	 /**
	 * Sets up login functionality with the below credentials on the routes specified in configure 
	 * Username - user
	 * Password - user
	 * 
	 * @see configure
	 */
	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	      .withUser("user").password("user").roles("USER");
	  }
}
