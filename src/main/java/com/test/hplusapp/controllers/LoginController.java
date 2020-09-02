package com.test.hplusapp.controllers;


import com.test.hplusapp.Login;
import com.test.hplusapp.beans.User;
import com.test.hplusapp.exceptions.ApplicationException;
import com.test.hplusapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login){
    User user=userRepository.searchByName(login.getUsername());
    if(user==null){
        throw new ApplicationException("user not found");
    }
        return "forward:/userprofile";
    }

 /*   @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("in exception handler of login Controller");
        return "error";
    }*/
}
