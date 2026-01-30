package com.digis01.ISanchezPruebaCajero.Service;

import com.digis01.ISanchezPruebaCajero.DAO.JwtBlacklistRepository;
import com.digis01.ISanchezPruebaCajero.JPA.JwtBlacklist;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class JwtBlacklistService {

    private final JwtBlacklistRepository repository;

    public JwtBlacklistService(JwtBlacklistRepository repository) {
        this.repository = repository;
    }

    public void blacklist(String token) {
        repository.save(new JwtBlacklist(token, LocalDateTime.now()));
    }

    public boolean isBlacklisted(String token) {
        return repository.existsByToken(token);
    }
}
