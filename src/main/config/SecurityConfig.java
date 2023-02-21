package main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("John").password(passwordEncoder().encode("admin")).roles("ADMIN", "EMPLOYEE")
			.and()
			.withUser("Eric").password(passwordEncoder().encode("employee")).roles("EMPLOYEE")
			.and()
			.withUser("Michael").password(passwordEncoder().encode("client")).roles("CLIENT")
			.and()
            .withUser("李").password(passwordEncoder().encode("test")).roles("ADMIN","EMPLOYEE");  
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		   CharacterEncodingFilter filter = new CharacterEncodingFilter();
	        filter.setEncoding("UTF-8");
	        filter.setForceEncoding(true);
	        http.addFilterBefore(filter, CsrfFilter.class);
		http.authorizeRequests()
		.antMatchers("/", "/login")
		.permitAll()
	.antMatchers("/addTour","/add-customer","/show-customer")
		.hasAnyRole("ADMIN", "EMPLOYEE")
	.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/checkUserAccount")
		.defaultSuccessUrl("/")
		.permitAll()
	.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true)
		.permitAll();
//	.and()
		//.exceptionHandling().accessDeniedPage("/forbidden");
//		.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        }
}
	

	
	

