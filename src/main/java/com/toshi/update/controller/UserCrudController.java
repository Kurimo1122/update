package com.toshi.update.controller;


import com.toshi.update.model.User;
import com.toshi.update.repository.UserRepository;
import com.toshi.update.service.UserCrudService;
import com.toshi.update.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.toshi.update.controller.MainController;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserCrudController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCrudService userCrudService;

    @GetMapping
    public String index(Model model){
        List<User> users = userCrudService.findAll();
        model.addAttribute("users", users);
        return "users/index";
    }


    @GetMapping("new")
    public String newUser(Model model){
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute User user){
        userCrudService.save(user);
        return "redirect:/users";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model){
        User user = userCrudService.findOne(id);
        model.addAttribute("user", user);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedinuser = userRepository.findByEmail(auth.getName());
        model.addAttribute("loggedInUser", loggedinuser);
        return "users/show";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        User user = userCrudService.findOne(id);
        model.addAttribute("user", user);
        boolean usernotloggedin = MainController.userNotLoggedIn();
        model.addAttribute("usernotloggedin", usernotloggedin);
        return "users/edit";
    }

    @PostMapping("{id}")
//    @RequestMapping(value={"{id}"}, method={RequestMethod.POST,RequestMethod.PUT})
//    public String update(@PathVariable Long id, @ModelAttribute User user){
      public String update(@ModelAttribute User user){
        userCrudService.save(user);
        return String.format("redirect:/users/%s", user.getId());
//        return "redirect:/secure/user";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id){
        userCrudService.delete(id);
        return "redirect:/users";
    }

}
