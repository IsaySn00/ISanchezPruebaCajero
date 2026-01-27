package com.digis01.ISanchezPruebaCajero.Security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioSecurity implements UserDetails {

    private final String numeroCuenta;
    private final String nip;
    private final Collection<? extends GrantedAuthority> authorities;

    public UsuarioSecurity(String numeroCuenta, String nip, String rol) {
        this.numeroCuenta = numeroCuenta;
        this.nip = nip;
        this.authorities = List.of(
                new SimpleGrantedAuthority("ROLE_" + rol)
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return nip;
    }

    @Override
    public String getUsername() {
        return numeroCuenta;
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
