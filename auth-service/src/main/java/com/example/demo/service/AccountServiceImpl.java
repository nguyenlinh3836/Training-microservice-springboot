package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AccountMapper;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    @Transactional
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passEncode = encoder.encode(account.getPassword());
        account.setPassword(passEncode);
        Optional<Account> optionalAccount = accountRepo.findByUsername(account.getUsername());
        account.setRoles(Arrays.asList(roleRepo.findByRolename("USER")));
        if (!optionalAccount.isPresent()){
            return accountMapper.toDto(accountRepo.save(account));
        }
        return null;
    }
}
