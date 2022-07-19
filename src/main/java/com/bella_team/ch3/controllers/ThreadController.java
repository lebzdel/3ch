package com.bella_team.ch3.controllers;

import com.bella_team.ch3.models.Thread;
import com.bella_team.ch3.repo.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ThreadController {
    @Autowired
    private ThreadRepository threadRepository;

    @GetMapping("/thread")
    public String threadMain(Model model){
        Iterable<Thread> threads = threadRepository.findAll();
        model.addAttribute("threads", threads);
        return "threadMain";
    }

    @GetMapping("/thread/add")
    public String threadAdd(Model model){
        return "threadAdd";
    }

    @PostMapping("/thread/add")
    public String threadPostAdd(@RequestParam String title,
                                @RequestParam String name,
                                @RequestParam String fullText, Model model) {

        Thread thread = new Thread(title, name, fullText);
        threadRepository.save(thread);

        return "redirect:/thread";
    }
}
