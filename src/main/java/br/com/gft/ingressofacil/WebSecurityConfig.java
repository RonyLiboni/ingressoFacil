package br.com.gft.ingressofacil;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.gft.ingressofacil.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	    
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserRepository userRepository;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/home","/cadastro","/cadastro/cadastrarCliente")
			.permitAll()
		.antMatchers("/casaDeShow/**","/evento/**").hasRole("ADM")
		.antMatchers("/comprar/**","/minhasCompras").hasRole("USER")
		.anyRequest()
			.authenticated()
		.and()
		.formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/home", true)
            .permitAll()
        )
		.logout(logout -> {
			logout.logoutUrl("/logout")
				.logoutSuccessUrl("/home");
		}).csrf().disable();
		
		
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	
				
		if(userRepository.findById("admin").isEmpty()){
			UserDetails user =
			 User.builder()
				.username("admin")
				.password(encoder.encode("admin"))
				.roles("ADM")
				.build();
			auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder).withUser(user);
			return;
		}

		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder);
	
	}
	
}
