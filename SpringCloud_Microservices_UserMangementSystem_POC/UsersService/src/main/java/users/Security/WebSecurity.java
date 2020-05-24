package users.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import users.Service.UsersService;

@Configuration
@EnableWebSecurity
    public class WebSecurity extends WebSecurityConfigurerAdapter {

    private UsersService usersService;
    private Environment environment;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurity(UsersService usersService, Environment environment, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersService = usersService;
        this.environment = environment;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/**").permitAll()
                .and().addFilter(getAuthenticationFilter());
        //http.authorizeRequests().antMatchers("/**").hasIpAddress(environment.getProperty("gateway.api"));
        http.headers().frameOptions().disable();
    }

    @Override
    protected void  configure (AuthenticationManagerBuilder auth) throws  Exception{
            auth.userDetailsService(usersService).passwordEncoder(bCryptPasswordEncoder);
    }

    private AuthenticationFilter getAuthenticationFilter  () throws Exception{
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(environment,usersService,authenticationManager());
        //authenticationFilter.setAuthenticationManager(authenticationManager());
    authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
        return authenticationFilter;
    }

}
