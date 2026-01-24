
package com.digis01.ISanchezPruebaCajero.DAO;

import com.digis01.ISanchezPruebaCajero.JPA.DetalleCajero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface DetalleCajeroRepository extends JpaRepository<DetalleCajero, Integer>{
    
    @Procedure(procedureName = "GetDetalleCajero") 
    List<DetalleCajero> getDetalleCajero(@Param("pIdCajero") int idCajero);

}
