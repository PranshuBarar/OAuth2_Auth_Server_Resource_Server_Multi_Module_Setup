package com.oauthsetup.resourceservice.controllers;


import com.oauthsetup.reposervice.Dto.UserDto;
import com.oauthsetup.reposervice.services.CustomUserDetails;
import com.oauthsetup.resourceservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    public static final Logger logger = Logger.getLogger(String.valueOf(UserController.class));

    @GetMapping("/")
    public String home(Authentication authentication){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return "hello " + userDetails.getUserEntity().getUsername();
    }

    @PutMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserDto userDto){
        String response = userService.signup(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
