package com.digis01.ISanchezPruebaCajero.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "jwtblacklist")
public class JwtBlacklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtkn")
    private int idTkn;
    
    @Column(name = "token")
    private String token;
    
    @Column(name = "fecharevocado")
    private LocalDateTime fechaRevocado;
    
    public JwtBlacklist(String token, LocalDateTime fechaRevocado) {
        this.token = token;
        this.fechaRevocado = fechaRevocado;
    }

    public int getIdTkn() {
        return idTkn;
    }

    public void setIdTkn(int idTkn) {
        this.idTkn = idTkn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getFechaRevocado() {
        return fechaRevocado;
    }

    public void setFechaRevocado(LocalDateTime fechaRevocado) {
        this.fechaRevocado = fechaRevocado;
    }
    
}
