package com.example.t2009m1springsecurity.entity.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRegisterDto {
    private long id;
    private String username;
    private String password;
    private String confirmPassword;
    private int role;
}
