package com.ageinghippy.oauth_demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping("/")
    public String anonymous(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "index.html";
    }

    @GetMapping("/protected")
    public String authenticated(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "index.html";
    }

}
