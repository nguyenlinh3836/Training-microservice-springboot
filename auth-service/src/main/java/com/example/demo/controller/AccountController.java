package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Resource(name = "tokenServices")
    private ConsumerTokenServices tokenServices;

    @Resource(name = "tokenStore")
    private TokenStore tokenStore;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.createAccount(accountDto));
    }
}
