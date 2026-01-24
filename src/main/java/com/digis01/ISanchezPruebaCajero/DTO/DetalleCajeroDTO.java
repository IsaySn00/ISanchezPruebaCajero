package com.digis01.ISanchezPruebaCajero.DTO;

import java.math.BigDecimal;

public class DetalleCajeroDTO {

    private Integer idDenominacion;
    private BigDecimal cantidadDinero;
    private Integer idTipo;
    private Integer idCajero;
    private BigDecimal montoDenominacion;

    public Integer getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(Integer idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public BigDecimal getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(BigDecimal cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Integer idCajero) {
        this.idCajero = idCajero;
    }

    public BigDecimal getMontoDenominacion() {
        return montoDenominacion;
    }

    public void setMontoDenominacion(BigDecimal montoDenominacion) {
        this.montoDenominacion = montoDenominacion;
    }
    
    
}
