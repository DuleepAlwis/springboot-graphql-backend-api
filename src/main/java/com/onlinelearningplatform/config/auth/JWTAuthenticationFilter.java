package com.onlinelearningplatform.config.auth;

import com.onlinelearningplatform.service.UserManagementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private UserManagementService userManagementService;

    private JWTTokenHelper jwtTokenHelper;


    static Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
    public JWTAuthenticationFilter(UserManagementService userManagementService, JWTTokenHelper jwtTokenHelper) {
        this.userManagementService = userManagementService;
        this.jwtTokenHelper = jwtTokenHelper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        logger.info("Inside doFilterInternal >");
        logger.info("request >" + request);

        String authToken = jwtTokenHelper.getToken(request);

        logger.info("authToken >>> " + authToken);



        if(authToken != null) {

            String email = jwtTokenHelper.getEmailFromToken(authToken);

            System.out.println("email >>> " + email);

            if(email != null && !email.equals("")) {
                UserDetails userDetails = userManagementService.loadUserByUsername(email);

                if(jwtTokenHelper.validateToken(authToken, userDetails)) {

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }

        }

        filterChain.doFilter(request, response);
    }
}
