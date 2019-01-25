package com.phoenix.jobpostings.validators;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.phoenix.jobpostings.models.User;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    public static Pattern EMAIL_REGEX = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+");

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (user.getFirstname().length() < 1 || user.getFirstname().length() > 20) {
            errors.rejectValue("firstname", null, "Firstname must be between 1 - 20 characters!");
        }
        if (user.getLastname().length() < 1 || user.getLastname().length() > 20) {
            errors.rejectValue("lastname", null, "Last name must be between 1 - 20 characters!");
        }
        if (user.getPassword().length() < 6 || user.getPassword().length() > 20) {
            errors.rejectValue("password", null, "Password must be between 6 - 20 characters!");
        }
        if (!EMAIL_REGEX.matcher(user.getEmail()).matches()) {
            errors.rejectValue("email", null, "Email does not comply with email standards!");
        }
        if (!user.getConfirm_password().equals(user.getPassword())) {
            // "Password Code" is "Match"
            // errors.rejectValue("passwordConfirmation", "Match");

            // Use this for Straight error message no error code...
            errors.rejectValue("confirm_password", null, "The Password and Confirm Password Must Match");
        }
    }
}