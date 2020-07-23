package security.example.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder(); //password encoder must be defined, otherwise you'll get NPE during login

        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("user"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN")
                .and()
                .withUser("guest")
                .password(encoder.encode("guest"))
                .roles("GUEST")
        .and()
        .passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin() //for user friendly /login page; visiting /logout ends session
                .and()
                .httpBasic() //for machines to login with basic authentication
                .and()
                .authorizeRequests()
                .regexMatchers("/gold.*").hasRole("USER") //remember to match paths with- and without the final "/"!
                .regexMatchers(HttpMethod.POST, "/deposit.*").authenticated()
                .anyRequest().permitAll();
    }
}
