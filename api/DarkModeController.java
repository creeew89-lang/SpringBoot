package com.example.demo.api;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/theme")
public class DarkModeController {

    @GetMapping
    public Map<String, Boolean> current(
            @CookieValue(value = "darkMode", defaultValue = "false") boolean darkMode) {
        return Map.of("darkMode", darkMode);
    }

    @PostMapping
    public Map<String, Boolean> toggle(
            @CookieValue(value = "darkMode", defaultValue = "false") boolean current,
            HttpServletResponse response) {

        boolean newValue = !current;
        Cookie cookie = new Cookie("darkMode", String.valueOf(newValue));
        cookie.setMaxAge(60 * 60 * 24 * 365);
        cookie.setPath("/");
        response.addCookie(cookie);
        return Map.of("darkMode", newValue);
    }
}