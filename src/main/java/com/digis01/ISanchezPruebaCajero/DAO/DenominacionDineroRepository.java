package com.digis01.ISanchezPruebaCajero.DAO;

import com.digis01.ISanchezPruebaCajero.JPA.DenominacionDinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DenominacionDineroRepository extends JpaRepository<DenominacionDinero, Integer>, DenominacionDineroRepositoryCustom{
        
}
