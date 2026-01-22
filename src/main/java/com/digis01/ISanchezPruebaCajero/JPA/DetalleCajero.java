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
@Table(name = "detallecajero")
public class DetalleCajero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetallecajero")
    private int idDetalleCajero;
    
    @Column(name = "cantidaddinero")
    private long cantidadDinero;
    
    @ManyToOne
    @JoinColumn(name = "iddenominacion", nullable = false)
    public DenominacionDinero DenominacionDinero;
    
    @ManyToOne
    @JoinColumn(name = "idtipo", nullable = false)
    public TipoDinero TipoDinero;
    
    @ManyToOne
    @JoinColumn(name = "idcajero", nullable = false)
    public Cajero Cajero;

    public int getIdDetalleCajero() {
        return idDetalleCajero;
    }

    public void setIdDetalleCajero(int idDetalleCajero) {
        this.idDetalleCajero = idDetalleCajero;
    }

    public long getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(long cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }
    
    
}
