package com.besmartkinopoiskservice.to.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRegisterRequestTO {
    @NotEmpty(message = "Имя пользователя является обязательным параметром")
    @Pattern(regexp = "^[a-zA-z0-9]{4,32}$", message = "Имя пользователя должно состоять из букв латинского алфавита и содержать от 4 до 32 символов")
    private String username;

    @NotEmpty(message = "Пароль является обязательным параметром")
    @Pattern(regexp = "^[a-zA-z0-9]{8,32}$", message = "Пароль должен состоять из букв латинского алфавита и содержать от 8 до 32 символов")
    private String password;
    private String passwordConfirmation;

    @NotEmpty(message = "Почта является обязательным параметром")
    @Email(message = "Неподходящий формат email")
    private String email;
}
