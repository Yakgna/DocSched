package com.esd.docsched.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.esd.docsched.pojo.User;

@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return (User.class.equals(type));
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "fname is empty", "First Name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "lname is empty", "Last Name cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password is empty", "Password cannot be empty");
        User user = (User) o;
        if (user.getPassword() != null
                && user.getPassword().trim().length() < 8) {
             errors.rejectValue("password", "field.min.length",
                   new Object[]{Integer.valueOf(8)},
                   "The password must be at least 8 characters in length.");
      	}
    }
    
}
