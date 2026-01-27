package com.digis01.ISanchezPruebaCajero.Component;

import com.digis01.ISanchezPruebaCajero.Service.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

     private final CustomUserDetailsService userDetailsService;

    public CustomAuthenticationProvider(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {

        String numeroCuenta = authentication.getName();
        String nip = authentication.getCredentials().toString();

        UserDetails user =
                userDetailsService.authenticate(numeroCuenta, nip);

        return new UsernamePasswordAuthenticationToken(
                user,
                nip,
                user.getAuthorities()
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
