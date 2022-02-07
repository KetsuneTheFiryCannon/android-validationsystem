package com.example.validationsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationPatterns {

    public static final Pattern VALID_EMAIL_PATTERN = Pattern.compile(
            "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&*^%]).{6,}$");

    public boolean validateEmail(User toValidate) {
        return validateEmail(toValidate.Email)
                && validatePass(toValidate.Password)
                && validatePassAndOriginalPass(toValidate.Password, toValidate.ConfirmPassword);
    }

    public boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_PATTERN.matcher(email);
        return matcher.find();
    }

    public boolean validatePass(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.find();
    }

    public boolean validatePassAndOriginalPass(String password, String confirmPassword) {
        return password.trim().equals(confirmPassword.trim());
    }
}