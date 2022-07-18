package com.example.t2009m1springsecurity.util;

import com.example.t2009m1springsecurity.entity.Account;
import org.testng.annotations.Test;

class testGenerate {
    @Test
    public void testGenerateToken(){
        Account account = Account.builder()
                .id(System.currentTimeMillis())
                .role(1)
                .username("quynhanh123")
                .passwordHash("xyz")
                .build();
        String accessToken = JwtUtil.generateTokenByAccount(account, 15 * 24 * 60 * 60 * 1000);
        System.out.println(accessToken);
    }
}