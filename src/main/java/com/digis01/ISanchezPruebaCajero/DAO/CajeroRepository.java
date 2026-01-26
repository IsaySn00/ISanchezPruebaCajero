package com.digis01.ISanchezPruebaCajero.DAO;

import com.digis01.ISanchezPruebaCajero.JPA.Cajero;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CajeroRepository extends JpaRepository<Cajero, Integer>, CajeroRepositoryCustom {

    @Procedure(procedureName = "GetMontoCajero", outputParameterName = "pTotalCajero")
    BigDecimal getMontoCajero(@Param("pIdCajero") int idCajero);

    @Procedure(procedureName = "RetirarDinero")
    Map<String, Object> retirarDinero(
            @Param("pIdUsuario") int idUsuario,
            @Param("pIdCajero") int idCajero,
            @Param("pMonto") BigDecimal monto
    );
    
    @Procedure(procedureName = "LlenarCajero")
    Map<String, Object> llenarCajero(
            @Param("pIdUsuario") int idUsuario,
            @Param("pIdCajero") int idCajero,
            @Param("pIdDenominacion") int idDenominacion,
            @Param("pCantidad") int cantidad
    );

}
