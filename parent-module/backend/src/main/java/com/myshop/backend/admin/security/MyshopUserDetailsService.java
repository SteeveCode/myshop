package com.myshop.backend.admin.security;

import com.myshop.backend.admin.user.UserRepository;
import com.myshop.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class MyshopUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.getUserByEmail(email);
        if (user != null) {
            return new MyshopUserDetails(user);
        }

        throw new UsernameNotFoundException("Could not find user with email: " + email);
    }
}
