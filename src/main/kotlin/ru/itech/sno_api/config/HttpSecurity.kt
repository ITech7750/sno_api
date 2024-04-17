package ru.itech.sno_api.config
/*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
//import ru.itech.sno_api.security.JWTAuthorizationFilter
import ru.itech.sno_api.service.LoginService

/*
@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Autowired
    private lateinit var loginService: LoginService

    @Autowired
    private lateinit var jwtAuthorizationFilter: JWTAuthorizationFilter

    @Bean
    fun authenticationManager(): AuthenticationManager {
        return AuthenticationManagerBuilder.popAuthenticationManager(userDetailsService(), passwordEncoder()).build()
    }


    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeRequests { authorizeRequests: ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry ->
            authorizeRequests.antMatchers("/api/v1/authorizations/*").permitAll()
                .antMatchers("/api/v1/users/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/users/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/organizations/").hasRole("ADMIN")
                .antMatchers("/api/v1/organizations/{id}").hasRole("ADMIN")
                .antMatchers("/api/v1/login").permitAll()
                .anyRequest().authenticated()
        }
            .and()
            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .securityMatcher("/**")  // Фильтруем все запросы

        return http.build()
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Qualifier("loginServiceImpl")
    @Bean
    fun userDetailsService(): LoginService {
        return loginService
    }
}

 */