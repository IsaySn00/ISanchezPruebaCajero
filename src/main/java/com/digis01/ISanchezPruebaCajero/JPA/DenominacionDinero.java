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
@Table(name = "denominaciondinero")
@NamedStoredProcedureQuery(
    name = "DenominacionDinero.getDenominaciones",
    procedureName = "GetDenominacion",
    resultClasses = DenominacionDinero.class,
    parameters = {
        @StoredProcedureParameter(
            mode = ParameterMode.REF_CURSOR,
            name = "pCursor",
            type = void.class
        )
    }
)
public class DenominacionDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddenominacion")
    private int idDenominacion;
    
    @Column(name = "montodenominacion")
    private BigDecimal montoDenominacion;

    public int getIdDenominacion() {
        return idDenominacion;
    }

    public void setIdDenominacion(int idDenominacion) {
        this.idDenominacion = idDenominacion;
    }

    public BigDecimal getMontoDenominacion() {
        return montoDenominacion;
    }

    public void setMontoDenominacion(BigDecimal montoDenominacion) {
        this.montoDenominacion = montoDenominacion;
    }
    
    
}
