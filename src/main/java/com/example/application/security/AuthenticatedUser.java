package com.example.application.security;

import java.util.Collections;
import java.util.Optional;

import com.example.application.data.entity.User;
import com.example.application.data.service.UserRepository;
import com.example.application.security.jwt.auth.VaadinJwtSecurityContextLogoutHandler;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.VaadinServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.jwt.Jwt;

@Component
public class AuthenticatedUser {

    @Autowired
    private UserRepository userRepository;

    private UserDetails getAuthenticatedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Object principal = context.getAuthentication().getPrincipal();
        if (principal instanceof Jwt) {
            String userName = ((Jwt) principal).getClaim("sub");
            return new org.springframework.security.core.userdetails.User(userName, "", Collections.emptyList());
        }
        return null;
    }

    public Optional<User> get() {
        UserDetails details = getAuthenticatedUser();
        if (details == null) {
            return Optional.empty();
        }
        return Optional.of(userRepository.findByUsername(details.getUsername()));
    }

    public void logout() {
        SecurityContextLogoutHandler logoutHandler = new VaadinJwtSecurityContextLogoutHandler();
        logoutHandler.setInvalidateHttpSession(false);
        logoutHandler.logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), 
            VaadinServletResponse.getCurrent().getHttpServletResponse(), null);
        UI.getCurrent().getPage().setLocation(SecurityConfiguration.LOGOUT_URL);
    }

}
