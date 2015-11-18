package mum.edu.blog.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import mum.edu.blog.domain.Blog;
import mum.edu.blog.domain.User;
import mum.edu.blog.exception.UnableToUploadImageException;
import mum.edu.blog.service.BlogService;
import mum.edu.blog.service.UserService;

@Controller
public class signUpController extends AbstractAction {

	@Value("${image.path}")
	private String path;
	
	private final static Logger LOGGER = Logger.getLogger(signUpController.class);
	
		@Autowired
		UserService userService;
		@Autowired
		BlogService blogService;
	
	public User prepareFlowForm(){
        User user= new User();
        return user;
       }
	
		public Event checkUserName(User user, MessageContext messageContext){
		
			if (userService.findByUsername(user.getUsername()) != null) {
				
				LOGGER.info("username found");
				MessageBuilder errorMessageBuilder = new MessageBuilder().error();
				errorMessageBuilder.source("user.username");
				errorMessageBuilder.code("username.unique").arg(user.getUsername()).defaultText("Username already exist").build();
				messageContext.addMessage(errorMessageBuilder.build());
				return error();
			}
			LOGGER.info("username not found");
			return success();

       }
	
		public Event checkBlogName(Blog newblog,MessageContext messageContext){
		
			if (blogService.findByBlogName(newblog.getBlogName()) != null) {
				LOGGER.info("blog found");
				MessageBuilder errorMessageBuilder = new MessageBuilder().error();
				errorMessageBuilder.source("newblog.blogName");
				errorMessageBuilder.code("blogName.unique").arg(newblog.getBlogName()).defaultText("Blogname already exist").build();
				messageContext.addMessage(errorMessageBuilder.build());
				return error();
			}
			LOGGER.info("blog not found");
			return success();
       }
	
	public Event saveUser(RequestContext context,User user) throws UnableToUploadImageException
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
	
	public Event saveUserAndBlog(User user,Blog blog) throws UnableToUploadImageException
	{
		System.out.println("*************************");
		if(user!=null){
			
			System.out.println(user.getFirstName() + " " + user.getUsername());
			
			if(blog!= null && blog.getBlogName().trim() !="") 
			{
				user.addBlog(blog);
			
				System.out.println("======: "+ user.getFirstName() + " "+ blog.getBlogName().toString());
			}
			
			//try{
			User saveduser = userService.save(user);
			MultipartFile userImage = user.getUserImage();
			
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
//			}catch(Exception ee)
//			{
//				System.out.println(ee.getMessage());
//				return error();
//			}
			
		return success();
		}
		else {
			return error();
			} //throw new InvalidUserException();}
			
	}

	@Override
	protected Event doExecute(org.springframework.webflow.execution.RequestContext arg0) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
