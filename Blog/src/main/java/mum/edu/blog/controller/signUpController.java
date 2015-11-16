package mum.edu.blog.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.webflow.execution.RequestContext;

import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;


import mum.edu.blog.domain.User;
import mum.edu.blog.exception.InvalidUserException;
import mum.edu.blog.exception.UnableToUploadImageException;
import mum.edu.blog.repository.UserRepository;
import mum.edu.blog.service.UserService;

@Controller
public class signUpController extends AbstractAction {

	@Value("${image.path}")
	private String path;
	
	private final static Logger LOGGER = Logger.getLogger(signUpController.class);
	
		@Autowired
		UserService userService;
	
	public User prepareFlowForm(){
        User user= new User();
        return user;
       }
	
	public Event bindAndValidate(RequestContext context,User user) throws UnableToUploadImageException
	{
		if(user!=null){

			User saveduser = userService.save(user);
			MultipartFile userImage = user.getUserImage();

			System.out.println(user.getUserImage().getName());
			System.out.println(path);
			
			// isEmpty means file exists BUT NO Content
			if (userImage != null && !userImage.isEmpty()) {
				try {

					userImage.transferTo(new File(path + saveduser.getId() + ".png"));

					LOGGER.info("Image moved succesfully to " + path);

				} catch (Exception e) {
					LOGGER.info(e.getMessage());
					throw new UnableToUploadImageException(null);
				}
			}
			
		return success();
		}
		else {return error(); } //throw new InvalidUserException();}
			
	}

	@Override
	protected Event doExecute(org.springframework.webflow.execution.RequestContext arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
