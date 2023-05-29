/*

package com.onlinelearningplatform.onlineLearningPlatform;

import com.onlinelearningplatform.config.auth.JWTAuthenticationFilter;
import com.onlinelearningplatform.config.auth.JWTTokenHelper;
import com.onlinelearningplatform.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Configuration
    @Order(1)
    public static class JWTWebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserManagementService userManagementService;

        @Autowired
        private JWTTokenHelper jwtTokenHelper;


        @Autowired
        private AuthenticationEntryPoint authenticationEntryPoint;


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            //auth.inMemoryAuthentication().withUser("abcd").password(passwordEncoder().encode("123456")).authorities("USER", "ADMIN");

            auth.userDetailsService(userManagementService).passwordEncoder(passwordEncoder());
        }


        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }


        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {



 */
/*http.cors().configurationSource(request -> {
                        var cors = new CorsConfiguration();
                        cors.setAllowedOrigins(List.of("http://localhost:3000", "http://127.0.0.1:3000"));
                        cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
                        cors.setAllowedHeaders(List.of("*"));
                        return cors;
                    })
                    .and()
                    .requestMatchers().antMatchers("/graphql/**")
                    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                    .and().authorizeRequests((request) -> request.antMatchers("/graphiql", "/vendor/graphiql/*").permitAll().antMatchers("/graphql").permitAll().anyRequest().authenticated())
                    .addFilterBefore(new JWTAuthenticationFilter(userManagementService, jwtTokenHelper), UsernamePasswordAuthenticationFilter.class);

            http.csrf().disable().cors().and().headers().frameOptions().disable();



        }*//*

        }
    }





}
*/
