package com.digis01.ISanchezPruebaCajero.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovimiento")
    private int idMovimiento;
    
    @Column(name = "montomovimiento")
    private BigDecimal montoMovimiento;
    
    @Column(name = "fechamovimiento")
    private Date fechaMovimiento;
    
    @ManyToOne
    @JoinColumn(name = "idcajero", nullable = false)
    public Cajero Cajero;
    
    @ManyToOne
    @JoinColumn(name = "idcuenta", nullable = false)
    public Cuenta Cuenta;

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public BigDecimal getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(BigDecimal montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }
    
    
}
