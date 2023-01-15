package com.ontu.lab6.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String index(Model model) 
    {
        char[] character = new char[] {'X', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X'};
        model.addAttribute("variable1", character[0]);
        model.addAttribute("variable2", character[1]);
        model.addAttribute("variable3", character[2]);
        model.addAttribute("variable4", character[3]);
        model.addAttribute("variable5", character[4]);
        model.addAttribute("variable6", character[5]);
        model.addAttribute("variable7", character[6]);
        model.addAttribute("variable8", character[7]);
        model.addAttribute("variable9", character[8]);
        return "index";
    }
}