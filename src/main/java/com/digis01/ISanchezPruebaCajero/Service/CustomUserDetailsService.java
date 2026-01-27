package com.digis01.ISanchezPruebaCajero.Service;

import com.digis01.ISanchezPruebaCajero.DAO.CuentaRepository;
import com.digis01.ISanchezPruebaCajero.Security.UsuarioSecurity;
import java.util.Map;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

     private final CuentaRepository cuentaRepository;

    public CustomUserDetailsService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public UserDetails authenticate(String numeroCuenta, String nip) {

        Map<String, Object> resp =
                cuentaRepository.loginCuenta(numeroCuenta, nip);

        if (resp.get("pRol") == null) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        String rol = resp.get("pRol").toString();

        return new UsuarioSecurity(
                numeroCuenta,
                nip,
                rol
        );
    }
}
