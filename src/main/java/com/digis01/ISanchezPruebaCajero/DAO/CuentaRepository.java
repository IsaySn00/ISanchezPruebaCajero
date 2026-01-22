package com.digis01.ISanchezPruebaCajero.DAO;

import com.digis01.ISanchezPruebaCajero.JPA.Cuenta;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
    
    @Procedure(procedureName = "GetMontoUsuario", outputParameterName = "pMontoCuenta")
    BigDecimal getMontoCuentaUsuario(@Param("pIdUsuario") int idUsuario);
}
