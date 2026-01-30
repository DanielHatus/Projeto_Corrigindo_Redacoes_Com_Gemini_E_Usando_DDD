package com.example.correct.Easy.infra.security.implementations;

import com.example.correct.Easy.infra.persistence.model.UserPersistence;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails{

    private UserPersistence entityPersistence;

    public UserDetailsImpl(UserPersistence entity){
        this.entityPersistence=entity;
    }


    public String getFullName(){
        return this.entityPersistence.getFullName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.entityPersistence.getPermission().name()));
    }

    @Override
    public String getPassword() {
        return this.entityPersistence.getPasswordLogin();
    }

    @Override
    public String getUsername() {
        return this.entityPersistence.getEmail();
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
