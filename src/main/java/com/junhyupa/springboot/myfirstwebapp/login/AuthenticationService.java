package com.junhyupa.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("junhyupa");
        boolean isValidPassword = password.equalsIgnoreCase("dummy");

        return isValidUserName && isValidPassword;
    }
}
