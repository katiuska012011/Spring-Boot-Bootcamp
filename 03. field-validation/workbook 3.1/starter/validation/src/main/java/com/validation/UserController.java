package com.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @GetMapping("/result")
    public String getResult(Model model) {
        return "result";
    }

    @PostMapping("/submitItem")
    public  String submitItem(@Valid User user, BindingResult result) {

        if(result.hasErrors()) return "sign-up";

        if(user.getLastName().equals(user.getFirstName())){
            result.rejectValue(user.getLastName(), "", "please enter valid data");
        }
        return "redirect:result";
    }
}
