package com.digis01.ISanchezPruebaCajero.DTO;

import java.math.BigDecimal;


public class RetiroDTO {

    private int idUsuario;
    
    private int idCajero;
    
    private BigDecimal monto;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
    
}
