package com.civa.busapi.auth.interfaces.rest;

import com.civa.busapi.shared.infrastructure.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {

        // Autenticar usuario
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        // Generar token
        var user = userDetailsService.loadUserByUsername(request.username());
        var token = jwtService.generateToken(user);

        return ResponseEntity.ok(Map.of(
                "token", token,
                "type", "Bearer"
        ));
    }

    public record LoginRequest(String username, String password) {}
}