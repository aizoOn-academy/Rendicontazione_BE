package com.aizoon.rendicontazione.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public class JsonAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final Pattern pattern = Pattern.compile("^(.+)@(.+)$");
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest;
        if(request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            Map<String, String> requestBody = parseRequestBody(request);
            String username = requestBody.get("username");
            if(username != null && !pattern.matcher(username).matches()) {
                username = null;
            }

            authRequest = new UsernamePasswordAuthenticationToken(username, requestBody.get("password"));
        } else {
            authRequest = new UsernamePasswordAuthenticationToken("", "");
        }

        setDetails(request, authRequest);
        return getAuthenticationManager().authenticate(authRequest);
    }

    private Map<String, String> parseRequestBody(HttpServletRequest request) {
        try(InputStream rawRequestBody = request.getInputStream()) {
            return objectMapper.readValue(rawRequestBody, Map.class);
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

}
