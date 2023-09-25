package com.besmartkinopoiskservice.util;

public class ValidationUserCredentials {
    public static ValidationResult checkLogin(String login) {
        ValidationResult result = new ValidationResult();
        for (Integer i = 0; i < login.length(); i++) {
            if (Character.isDigit(login.charAt(i)) || Character.isAlphabetic(login.charAt(i))) {
                if (i.equals(login.length() - 1)) {
                    result.setIsSuccess(true);
                    return result;
                }
            } else {
                result.setIsSuccess(false);
                result.addErrMesaeges("Недопустимое имя пользователя");
                return result;
            }
        }
        return result;
    }


    public ValidationResult checkPassword(String password) {
        ValidationResult result = new ValidationResult();
        if (password.length() >= 8 && password.length() <= 32) {
            result.setIsSuccess(true);
            return result;
        } else {
            result.setIsSuccess(false);
            result.addErrMesaeges("Недопуcтимый размер пароля");
            return result;
        }
    }
}
