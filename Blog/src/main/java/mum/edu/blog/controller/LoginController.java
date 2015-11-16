package mum.edu.blog.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    
	    if(name.equals("anonymousUser"))
	    	return "login";
	    else return "redirect:/";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logout(Model model) {
// 		return "redirect:/";
// 	}
	
//	@RequestMapping(value="/signUp", method = RequestMethod.GET)
//	public String signup(@ModelAttribute("newUser") User user) {
//		
//		System.out.println("get method coming");
// 		return "signUp";
// 	}
//	
//	@RequestMapping(value="/signUp", method = RequestMethod.POST)
//	public String userSave(@ModelAttribute("newUser") @Valid User user, BindingResult result) {
// 		if(result.hasErrors()) return "signUp";
// 		
// 		System.out.println("post method coming");
// 		return "home";
// 	}
}
