package com.example.application.security.jwt.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

public class VaadinJwtSecurityContextLogoutHandler extends SecurityContextLogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        JwtSplitCookieUtils.removeJwtSplitCookies(request, response);
        super.logout(request, response, authentication);
    }
    
}
