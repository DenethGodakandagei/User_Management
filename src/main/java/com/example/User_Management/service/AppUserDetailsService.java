package com.example.User_Management.service;

import com.example.User_Management.entity.UserEntity;
import com.example.User_Management.repository.UserRepositiry;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepositiry userRepositiry;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity existingUser = userRepositiry.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User email not found"));

        return new User(
                existingUser.getEmail(),
                existingUser.getPassword(),
                new ArrayList<>() // authorities can be populated based on roles/permissions
        );
    }
}
