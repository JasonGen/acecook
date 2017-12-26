package com.spring.henallux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import static com.spring.henallux.controller.MyAccountController.BASKET;
import static com.spring.henallux.controller.MyAccountController.CURRENT_USER;


@Controller
@RequestMapping(value = "/index")
@SessionAttributes({CURRENT_USER, BASKET})
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {

        return "integrated:index";
    }


}
