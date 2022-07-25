package com.aizoon.rendicontazione.listeners;

import com.aizoon.rendicontazione.model.AuthenticatedUser;
import com.aizoon.rendicontazione.model.dto.response.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessListener implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;

    public AuthenticationSuccessListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.getWriter().print(
                objectMapper.writeValueAsString(

                        new UserResponse().from( 
                            ( ((AuthenticatedUser) authentication.getPrincipal()).getUser() ) 
                        )
                        
                )
        );
    }
}
