package com.gmail.heroes.heroes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@Profile("oauth-security")
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
/*
	@Autowired
	private UserDetailsService userDetailsService;	
	
  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
     //auth.inMemoryAuthentication()
     //    .withUser("admin").password("admin").roles("ROLE");
	  
	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	 System.out.println(encoder.encode("admin"));  
  }
*/
  @Override
  public void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests()
             .antMatchers("/api/user*").anonymous()
             .anyRequest().authenticated()
             .and()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
             .csrf().disable();
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
      resources.stateless(true);
  }
 
/*	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
*/
	@Bean
	public MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
	}
}

