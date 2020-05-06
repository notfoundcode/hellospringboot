package com.notfoundcode.hellobpringboot.application.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloResource {

    @GetMapping("/")
    public String getHello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("helloAttribute", "Hello, " + name + "!");
        return "home";
    }
}
