package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Role;
import com.example.demo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = accountRepo.findByUsername(username);
        if (!account.isPresent()) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return new User(username, account.get().getPassword(), mapRolesToAuthorities(account.get().getRoles()));
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toList());
    }
}
