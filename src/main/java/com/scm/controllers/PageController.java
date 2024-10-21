package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("home page handler");
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtubeChannel", "Learn Code with Durgesh");
        return "home";
    }

    // about route
    @RequestMapping("/about")  
    public String aboutPage(){
        return "about";
    }

    //services
    // about route
    @RequestMapping("/services")  
    public String servicesPageLoading(){
        return "services";
    }
    

}
