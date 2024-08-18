package com.project.SpringSec.service;

import com.project.SpringSec.model.UserPrincipal;
import com.project.SpringSec.model.Users;
import com.project.SpringSec.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found");
        }else{
            return new UserPrincipal(user);
        }
    }
}
