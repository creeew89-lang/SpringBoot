package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public User create(UserDto dto) {
        return repo.save(User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build());
    }

    public UserRepository getRepo() {
        return repo;
    }
}