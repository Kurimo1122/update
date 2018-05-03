package com.toshi.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.toshi.update.model.User;
import com.toshi.update.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoggedInUserController {

//    @GetMapping(path = "/loginForm")
//    String loginForm(){
//        return "loginForm";
//    }

    @Autowired
    private UserRepository userRepository;
//
//    @ModelAttribute("loggedInUser")
//    public void secure(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userRepository.findByEmail(auth.getName());
//        model.addAttribute("loggedInUser", user);
//    }
//
    @GetMapping("/secure/user")
    public String securePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("------hey-----");
        System.out.println(auth.getName());
        User user = userRepository.findByEmail(auth.getName());
        model.addAttribute("loggedInUser", user);
        return "secure/user";
    }
//
//    /** If we can't find a user/email combination */
//    @RequestMapping("/login-error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "loginForm";
//    }


}
