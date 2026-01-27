package com.digis01.ISanchezPruebaCajero.RestController;

import com.digis01.ISanchezPruebaCajero.DTO.LoginRequest;
import com.digis01.ISanchezPruebaCajero.JPA.Result;
import com.digis01.ISanchezPruebaCajero.JWT.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
            JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest request) {

        Result result = new Result();

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getNumeroCuenta(),
                            request.getNip()
                    )
            );

            String token = jwtService.generateToken(auth);

            result.correct = true;
            result.object = token;
            result.status = 201;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.status = 500;
        }

        return ResponseEntity.status(result.status).body(result);
    }
}
