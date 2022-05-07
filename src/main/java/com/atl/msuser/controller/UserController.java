package com.atl.msuser.controller;

import com.atl.msuser.dao.entity.User;
import com.atl.msuser.model.dto.UserLoginDto;
import com.atl.msuser.model.dto.UserRegisterDto;
import com.atl.msuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registration")
    public User register(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        return userService.register(userRegisterDto);
    }

    @GetMapping
    public String login(@RequestBody @Valid UserLoginDto userLoginDto){
        return userService.login(userLoginDto);
    }

}
