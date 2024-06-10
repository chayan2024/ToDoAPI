package org.example.todoapi.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.example.todoapi.dto.LoginDto;
import org.example.todoapi.dto.RegisterDto;
import org.example.todoapi.entity.Role;
import org.example.todoapi.entity.User;
import org.example.todoapi.exception.TodoApiException;
import org.example.todoapi.repository.RoleRepository;
import org.example.todoapi.repository.ToDORepository;
import org.example.todoapi.repository.UserRepository;
import org.example.todoapi.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ToDORepository toDORepository;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDto registerDto) {

        // check username is already exists in database
        if(Boolean.TRUE.equals(userRepository.existsByUsername(registerDto.getUsername()))){
            throw new TodoApiException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        // check email is already exists in database
        if(Boolean.TRUE.equals(userRepository.existsByEmail(registerDto.getEmail()))){
            throw new TodoApiException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully!.";
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));    

                SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User Logged- in Successfully";
    }

}
