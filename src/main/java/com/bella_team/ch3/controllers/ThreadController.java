package com.bella_team.ch3.controllers;

import com.bella_team.ch3.models.Thread;
import com.bella_team.ch3.repo.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

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

    @GetMapping("/thread/{id}")
    public String threadFull(@PathVariable(value = "id") Long threadId, Model model){
        if (!threadRepository.existsById(threadId)) {
            return "redirect:/thread";
        }

        Optional<Thread> thread =  threadRepository.findById(threadId);
        ArrayList<Thread> res = new ArrayList<>();
        thread.ifPresent(res::add);
        model.addAttribute("thread", res);
        return "threadFull";
    }

    @GetMapping("/thread/{id}/edit")
    public String threadFullEdit(@PathVariable(value = "id") Long threadId, Model model){
        if (!threadRepository.existsById(threadId)) {
            return "redirect:/thread";
        }

        Optional<Thread> thread =  threadRepository.findById(threadId);
        ArrayList<Thread> res = new ArrayList<>();
        thread.ifPresent(res::add);
        model.addAttribute("thread", res);
        return "threadFullEdit";
    }

    @PostMapping("/thread/{id}/edit")
    public String threadPostUpdate(@PathVariable(value = "id") Long threadId,
                                   @RequestParam String title,
                                   @RequestParam String name,
                                   @RequestParam String fullText, Model model) {

        Thread thread = threadRepository.findById(threadId).orElseThrow();
        thread.update(title, name, fullText);

        threadRepository.save(thread);

        return "redirect:/thread";
    }

    @PostMapping("/thread/{id}/delete")
    public String threadPostDelete(@PathVariable(value = "id") Long threadId, Model model) {

        Thread thread = threadRepository.findById(threadId).orElseThrow();
        threadRepository.delete(thread);

        return "redirect:/thread";
    }
}
