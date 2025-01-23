package com.ageinghippy.oauth_demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {

    @GetMapping({"/", ""})
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

    @GetMapping("/homepage")
    public String homepage(Model model, Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "homepage.html";
    }

    @GetMapping("/logout-success")
    public String logoutSuccess(Model model, Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "logout-success.html";
    }

//    @GetMapping("/login/oauth2/code/google")
//    public String googleAuthenticated(Authentication authentication) {
//        System.out.println("**** hitting /login/oauth2/code/google ***");
//        if (authentication != null) {
//            System.out.println(authentication);
//        }
//        return "redirect:/protected";
//    }


}
