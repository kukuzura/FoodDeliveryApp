package yurusova.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import yurusova.service.security.AuthorizationService;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@ComponentScan("yurusova")
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Resource
	AuthorizationService authorizationService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(authorizationService);
		authProvider.setPasswordEncoder(passwordEncoder());
	return authProvider;
	}

/*	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}*/

/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/index").authenticated()
				.and().formLogin().loginPage("/login").permitAll()
				.and().logout().permitAll();

		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin").authorities("ROLE_USER").and()
				.withUser("javainuse").password("javainuse").authorities("ROLE_USER", "ROLE_ADMIN");
	}*/
/*@Autowired
public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
	authenticationMgr.inMemoryAuthentication().withUser("admin1").password("admin1").authorities("ROLE_USER").and()
			.withUser("javainuse").password("$2y$12$y0aMRVYJMHxL2m0jwZei9uy8dWWwEMRZk0Wr2mh4T9T/UmN6t/bkm").authorities("ROLE_USER", "ROLE_ADMIN");
}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		// включаем защиту от CSRF атак

		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and()

				.formLogin()
				// указываем страницу с формой логина
				.loginPage("/login")
				// указываем action с формы логина
				.usernameParameter("j_username")
				.passwordParameter("j_password")

				// указываем URL при неудачном логине
				.failureUrl("/login?error=true")
				// Указываем параметры логина и пароля с формы логина
				.defaultSuccessUrl("/", true)
				// даем доступ к форме логина всем
				.permitAll();

		http.logout()
				// разрешаем делать логаут всем
				.permitAll()
				// указываем URL логаута
				.logoutUrl("/logout")
				// указываем URL при удачном логауте
				.logoutSuccessUrl("/")
				// делаем не валидной текущую сессию
				.invalidateHttpSession(true);

	}
}