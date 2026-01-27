package com.digis01.ISanchezPruebaCajero.DAO;

import java.util.Map;

public interface CuentaRepositoryCustom {

    Map<String, Object> loginCuenta(String numeroCuenta, String nip);
}
