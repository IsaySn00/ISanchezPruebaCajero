package com.digis01.ISanchezPruebaCajero.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentausuario")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuenta")
    private int idCuenta;
    
    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    public Usuario Usuario;
    
    @Column(name = "montocuenta")
    private long montoCuenta;

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public long getMontoCuenta() {
        return montoCuenta;
    }

    public void setMontoCuenta(long montoCuenta) {
        this.montoCuenta = montoCuenta;
    }
    
    
}
