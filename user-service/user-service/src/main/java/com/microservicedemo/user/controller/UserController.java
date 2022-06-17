package com.microservicedemo.user.controller;

import com.microservicedemo.user.VO.ResponseTemplateVo;
import com.microservicedemo.user.entity.User;
import com.microservicedemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody  User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId){

        return userService.getUserWithDepartment(userId);
    }
}
