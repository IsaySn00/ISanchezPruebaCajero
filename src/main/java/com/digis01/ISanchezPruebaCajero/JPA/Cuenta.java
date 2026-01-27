package com.digis01.ISanchezPruebaCajero.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cuentausuario")
@NamedStoredProcedureQuery(
    name = "Cuenta.loginCuenta",
    procedureName = "LoginCuenta",
    parameters = {
        @StoredProcedureParameter(
            mode = ParameterMode.IN,
            name = "pNumeroCuenta",
            type = String.class
        ),
        @StoredProcedureParameter(
            mode = ParameterMode.IN,
            name = "pNip",
            type = String.class
        ),
        @StoredProcedureParameter(
            mode = ParameterMode.OUT,
            name = "pRol",
            type = String.class
        ),
        @StoredProcedureParameter(
            mode = ParameterMode.OUT,
            name = "pIdUsuario",
            type = Integer.class
        )
    }
)
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcuenta")
    private int idCuenta;
    
    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    public Usuario Usuario;
    
    @Column(name = "numerocuenta")
    private String numeroCuenta;
    
    @Column(name = "montocuenta")
    private BigDecimal montoCuenta;
    
    @Column(name = "nipusuario")
    private String nipUsuario;

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    

    public BigDecimal getMontoCuenta() {
        return montoCuenta;
    }

    public void setMontoCuenta(BigDecimal montoCuenta) {
        this.montoCuenta = montoCuenta;
    }

    public String getNipUsuario() {
        return nipUsuario;
    }

    public void setNipUsuario(String nipUsuario) {
        this.nipUsuario = nipUsuario;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    
}
