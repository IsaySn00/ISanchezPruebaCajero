package com.digis01.ISanchezPruebaCajero.DAO;

import com.digis01.ISanchezPruebaCajero.JPA.Cajero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import java.util.List;

public class CajeroRepositoryImpl implements CajeroRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cajero> getCajeros() {
        StoredProcedureQuery query
                = entityManager.createNamedStoredProcedureQuery("Cajero.getCajeros");

        return query.getResultList();
    }

}
