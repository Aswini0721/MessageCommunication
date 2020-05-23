package com.messages.demo.MessageCommunication.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.messages.demo.MessageCommunication.model.User_Messages;
import com.messages.demo.MessageCommunication.repository.MessageRepository;
 
@Controller
public class MainController {
	

	@Autowired
	private MessageRepository messageRepository; 
 
    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        String username = (String) request.getSession().getAttribute("username");
       System.out.println(" I am in" +username);
        if (username == null || username.isEmpty()) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
 
        return "chat";
    }
 
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }
 
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, @RequestParam(defaultValue = "") String username) {
        username = username.trim();
 
        if (username.isEmpty()) {
            return "login";
        }
        request.getSession().setAttribute("username", username);
 
        return "redirect:/";
    }
 
    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).invalidate();
         
        return "redirect:/login";
    }
	
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 public String showWelcomePage(ModelMap model) {
		 List<User_Messages> users = messageRepository.findAllByUserId();
	      System.out.println("User History saved in DB" + users.toString());
		  model.addAttribute("users", users);
		  return "userHistory";
	  }
     
}
