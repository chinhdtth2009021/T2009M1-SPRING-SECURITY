package com.example.t2009m1springsecurity.restApi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @RequestMapping(method = RequestMethod.GET)
    public  String say(){
        return "Hello admin";
    }
}
