package com.fullstack.employee.leave.management.system.security;

import com.fullstack.employee.leave.management.system.UserModel.User;
import com.fullstack.employee.leave.management.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      User user= userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
       return new org.springframework.security.core.userdetails.User(user.getEmail() ,user.getPassword(), new ArrayList<>());
    }
}
