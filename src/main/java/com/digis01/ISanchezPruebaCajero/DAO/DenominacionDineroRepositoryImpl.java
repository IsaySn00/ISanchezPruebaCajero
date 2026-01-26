
package com.digis01.ISanchezPruebaCajero.DAO;

import com.digis01.ISanchezPruebaCajero.JPA.DenominacionDinero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import java.util.List;

public class DenominacionDineroRepositoryImpl implements DenominacionDineroRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<DenominacionDinero> getDenominaciones() {
        
        StoredProcedureQuery query =
            entityManager.createNamedStoredProcedureQuery(
                "DenominacionDinero.getDenominaciones"
            );

        return query.getResultList();
    }
    
}
