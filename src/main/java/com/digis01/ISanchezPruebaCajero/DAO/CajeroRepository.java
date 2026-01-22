package com.digis01.ISanchezPruebaCajero.DAO;

import com.digis01.ISanchezPruebaCajero.JPA.Cajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CajeroRepository extends JpaRepository<Cajero, Integer>{

    @Procedure(procedureName = "GetMontoCajero", outputParameterName = "pTotalCajero")
    Long getMontoCajero(@Param("pIdCajero") int idCajero);
}
