package com.digis01.ISanchezPruebaCajero.DAO;

import com.digis01.ISanchezPruebaCajero.JPA.DenominacionDinero;
import java.util.List;

public interface DenominacionDineroRepositoryCustom {
        List<DenominacionDinero> getDenominaciones();
}
