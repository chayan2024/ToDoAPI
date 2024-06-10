package org.example.todoapi.service;

import org.example.todoapi.dto.LoginDto;
import org.example.todoapi.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);

}
