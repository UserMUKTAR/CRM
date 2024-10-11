package com.easybyts.CRM.controller;

import com.easybyts.CRM.model.Users;
import com.easybyts.CRM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user)  {

        return service.verify(user);
    }

}
