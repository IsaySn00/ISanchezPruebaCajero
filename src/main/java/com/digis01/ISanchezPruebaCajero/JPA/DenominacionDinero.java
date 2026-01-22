package com.digis01.ISanchezPruebaCajero.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "denominaciondinero")
public class DenominacionDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddenominacion")
    private int idDenominacion;
    
    @Column(name = "montodenominacion")
    private long montoDenominacion;

    public int getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(int idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public long getMontoDenominacion() {
        return montoDenominacion;
    }

    public void setMontoDenominacion(long montoDenominacion) {
        this.montoDenominacion = montoDenominacion;
    }
    
    
}
