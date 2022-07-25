package com.aizoon.rendicontazione.model;

import com.aizoon.rendicontazione.model.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class AuthenticatedUser implements UserDetails {

    private transient User user;
    private String username;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static AuthenticatedUser createFrom(User user) {
        AuthenticatedUser authenticatedUser = new AuthenticatedUser();

        authenticatedUser.user = user;
        authenticatedUser.username = user.getEmail();
        authenticatedUser.password = user.getPassword();

        authenticatedUser.authorities = new ArrayList<>();

        return authenticatedUser;
    }

    private AuthenticatedUser() {}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
