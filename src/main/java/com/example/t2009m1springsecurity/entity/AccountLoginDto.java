package com.example.t2009m1springsecurity.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor

public class AccountLoginDto {
    private long id;
    private String username;
    private String password;
    private String confirmPassword;
    private int role;
}
