package com.example.t2009m1springsecurity;

import com.example.t2009m1springsecurity.entity.dto.AccountRegisterDto;
import com.example.t2009m1springsecurity.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//public class Testapi {
//}
@RunWith(SpringRunner.class)
@SpringBootTest(classes = T2009m1SpringSecurityApplication.class)
public class Testapi {
    @Autowired
    AccountService accountService;

    @Test
    public void register(){
        AccountRegisterDto accountRegisterDto = new AccountRegisterDto();
        accountRegisterDto.setUsername("Thuong");
        accountRegisterDto.setPassword("15975");
        accountRegisterDto.setRole(1);
        AccountRegisterDto afterCreate = accountService.register(accountRegisterDto);
        System.out.println(afterCreate);
    }
}
