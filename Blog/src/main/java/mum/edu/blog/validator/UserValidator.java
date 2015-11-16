package mum.edu.blog.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mum.edu.blog.domain.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User)o;

		if (StringUtils.isBlank(user.getFirstName())) {
			errors.rejectValue("firstName", null, "First name must not be empty");
		}
		if (user.getFirstName().length() > 30) {
			errors.rejectValue("firstName", null, "First name should not be longer than 30 characters");
		}
		if (StringUtils.isBlank(user.getLastName())) {
			errors.rejectValue("lastName", null, "Last name must not be empty");
		}
		if (user.getLastName().length() > 50) {
			errors.rejectValue("lastName", null, "Last name should not be longer than 50 characters");
		}
//		if (user.getAge() < 18) {
//			errors.rejectValue("age", null, "Customers must be 18 years or older");
//		}
//		if (user.getAge() > 120) {
//			errors.rejectValue("age", null, "We do not do business with the undead");
//		}
	}

}
