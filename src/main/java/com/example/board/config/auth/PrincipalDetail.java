package com.example.board.config.auth;

import com.example.board.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetail implements UserDetails {

    private User user;

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Not expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Not locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Not expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // enabled
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_" + user.getRole();
            }
        });

        return collectors;
    }

}
