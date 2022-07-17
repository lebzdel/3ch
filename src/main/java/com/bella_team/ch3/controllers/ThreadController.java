package com.bella_team.ch3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThreadController {

    @GetMapping("/thread")
    public String threadMain(Model model){
        return "threadMain";
    }
}
