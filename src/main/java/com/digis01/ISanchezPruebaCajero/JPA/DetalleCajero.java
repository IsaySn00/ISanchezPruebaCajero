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
@Table(name = "detallecajero")
@NamedStoredProcedureQuery(
name = "DetalleCajero.getDetalleCajero",
    procedureName = "GetDetalleCajero",
    resultClasses = DetalleCajero.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pIdCajero", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "pCursor", type = void.class)
    }
)
public class DetalleCajero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetallecajero")
    private int idDetalleCajero;
    
    @Column(name = "cantidaddinero")
    private BigDecimal cantidadDinero;
    
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

    public BigDecimal getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(BigDecimal cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }
    
    
}
