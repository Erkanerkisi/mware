package com.ecosystem.mware.security;

import com.ecosystem.mware.model.User;
import com.ecosystem.mware.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        return userService.getUserByUsername(s);
    }

    public User loadUserById(Long id){
        return userService.loadUserById(id);
    }

}
