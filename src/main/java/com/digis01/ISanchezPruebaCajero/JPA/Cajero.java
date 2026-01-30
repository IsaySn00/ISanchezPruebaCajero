package com.digis01.ISanchezPruebaCajero.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cajero")
@NamedStoredProcedureQuery(
    name = "Cajero.retirarDinero",
    procedureName = "RetirarDinero",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pIdUsuario", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pIdCajero",  type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pMonto",     type = BigDecimal.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pResultado", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pMensaje",   type = String.class)
    }
)
@NamedStoredProcedureQuery(
    name = "Cajero.llenarCajero",
    procedureName = "LlenarCajero",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pIdUsuario",      type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pIdCajero",       type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pIdDenominacion", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pCantidad",       type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pMensaje",        type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pResultado",      type = String.class)

    }
)
@NamedStoredProcedureQuery(
    name = "Cajero.getCajeros",
    procedureName = "GetCajeros",
    resultClasses = Cajero.class,
    parameters = {
        @StoredProcedureParameter(
            mode = ParameterMode.REF_CURSOR,
            name = "pCursor",
            type = void.class
        )
    }
)
public class Cajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcajero")
    public int idCajero;
    
    @Column(name = "nombrecajero")
    public String nombreCajero;

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }
    
    
}
