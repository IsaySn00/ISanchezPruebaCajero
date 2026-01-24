package com.digis01.ISanchezPruebaCajero.DTO;

public class LlenarCajeroDTO {

    private int idUsuario;
    private int idCajero;
    private int idDenominacion;
    private int cantidad;

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

    public int getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(int idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
