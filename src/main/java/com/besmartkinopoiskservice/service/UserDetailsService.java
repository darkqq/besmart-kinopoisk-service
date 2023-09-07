package com.besmartkinopoiskservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public abstract class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    public abstract UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
