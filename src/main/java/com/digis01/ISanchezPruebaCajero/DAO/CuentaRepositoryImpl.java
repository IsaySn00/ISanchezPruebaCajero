package com.digis01.ISanchezPruebaCajero.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import java.util.HashMap;
import java.util.Map;

public class CuentaRepositoryImpl implements CuentaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Map<String, Object> loginCuenta(String numeroCuenta, String nip) {
        
        StoredProcedureQuery query
                = entityManager.createNamedStoredProcedureQuery("Cuenta.loginCuenta");

        query.setParameter("pNumeroCuenta", numeroCuenta);
        query.setParameter("pNip", nip);

        query.execute();

        Map<String, Object> result = new HashMap<>();
        result.put("pRol", query.getOutputParameterValue("pRol"));
        result.put("pIdUsuario", query.getOutputParameterValue("pIdUsuario"));

        return result;
    }

}
