package mum.edu.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.blog.exception.InvalidUserException;
import mum.edu.blog.exception.UnableToUploadImageException;

@Component
@ControllerAdvice
public class ControllerExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = AccessDeniedException.class)
	public String accessDenied(HttpServletRequest httpServletRequest) {
		System.out.println(httpServletRequest.getRequestURI());

		System.out.println("Access denied");
		return "error-forbidden";
	}

	@ExceptionHandler(UnableToUploadImageException.class)
	public ModelAndView handleError(HttpServletRequest req, UnableToUploadImageException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("unableToUpload", exception.getFullMessage());
		mav.setViewName("UnableToUploadImage");
		return mav;
	}

//	@ExceptionHandler(InvalidUserException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public DomainError InvalidUserException(HttpServletRequest req, InvalidUserException exception) {
//		DomainError error = new DomainError();
//		error.setMessage(exception.getClass().getSimpleName());
//		return error;
//	}

}
