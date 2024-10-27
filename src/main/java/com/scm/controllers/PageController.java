package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helper.Message;
import com.scm.helper.MessageType;
import com.scm.services.UserServices;

import jakarta.servlet.http.HttpSession;



@Controller
public class PageController {

    @Autowired
    private UserServices userServices;

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

    @RequestMapping("/contact")
    public String contactPageLoading(){
        return "contact";
    }

    @RequestMapping("/login")
    public String loginPageLoading(){
        return "login";
    }

    @RequestMapping("/register")
    public String registerPageLoading(Model model){
        UserForm userForm = new UserForm();
        //userForm.setName("Varun");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession httpSession){
        System.out.println("Processing Register");

        //fetch data
        System.out.println(userForm);
        //validate form data


        //save to database
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

        User savedUser = userServices.saveUser(user);

        System.out.println("user saved :");

        //message = "Registration Successful"

        Message message = Message.builder().content("Registration Successful").type(MessageType.blue).build();

        httpSession.setAttribute("message",message);

        //Redirect To Login Page

        return "redirect:/register";
    }
    

}
