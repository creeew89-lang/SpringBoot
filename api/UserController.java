package com.example.demo.api;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public List<User> all() {
        return service.getRepo().findAll();
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/test-ex")
    public String test() {
        throw new RuntimeException("global handler test");
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Long id) {
        return service.getRepo().findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}