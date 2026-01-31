package com.example.correct.Easy.infra.security.implementations;

import com.example.correct.Easy.core.domain.model.UserDomain;
import com.example.correct.Easy.infra.persistence.model.UserPersistence;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails{

    private UserDomain userDomain;

    public UserDetailsImpl(UserDomain entity){
        this.userDomain=entity;
    }

    public Long getId(){
        return this.userDomain.getId();
    }

    public String getFullName(){
        return this.userDomain.getFullName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.userDomain.getPermission().name()));
    }

    @Override
    public String getPassword() {
        return this.userDomain.getPasswordLogin();
    }

    @Override
    public String getUsername() {
        return this.userDomain.getEmail();
    }

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
