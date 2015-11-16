package mum.edu.blog.service;

import mum.edu.blog.domain.User;

public class signUpService {
	
	public String performLogin(User user)
	{
		System.out.println("It is coming"); 
		
		if(user.getUsername() != null && user.getUsername().trim().equalsIgnoreCase("alba")
		&& user.getPassword() != null && user.getPassword().trim().equalsIgnoreCase("pass")){
		//user successfully logged in
		return "success";
		} else {
		return "failed";
		}
	}
	
	public User prepareFlowForm(){
        User user= new User();
        return user;
       }

}
