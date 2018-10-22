package com.oscarspring.tournaments.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class TournamentSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select email, password, enable from users where email=?")
			.authoritiesByUsernameQuery("select u.email, a.authority from users u inner join authorities a on (u.id_authority = a.id_authority) where u.email=?")
			.passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/user_home").hasAuthority("Admin")
				//.anyRequest().authenticated()
				//.antMatchers("/log").hasRole("USER")
				//.antMatchers("/log/tournaments").permitAll()
				.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.permitAll()
				.and()
			.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(60*60)
				.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
	
	 @Bean
	 public PersistentTokenRepository persistentTokenRepository() {
	  JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
	  db.setDataSource(dataSource);
	  
	  return db;
	 }

}