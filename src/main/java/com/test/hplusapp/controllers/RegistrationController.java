package com.test.hplusapp.controllers;

import com.test.hplusapp.beans.User;
import com.test.hplusapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, "dateOfBirth",new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"),true));
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("newuser")User user, BindingResult result, Model model){
        System.out.println("registration controller");
        System.out.println(user.getDateOfBirth());

        if(result.hasErrors()){
            return "register";
        }

        userRepository.save(user);
        model.addAttribute("dataSaved","User registered successfully");

        return "login";
    }

}
