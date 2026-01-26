package com.digis01.ISanchezPruebaCajero.Service;

import com.digis01.ISanchezPruebaCajero.DAO.CajeroRepository;
import com.digis01.ISanchezPruebaCajero.DAO.DetalleCajeroRepository;
import com.digis01.ISanchezPruebaCajero.DTO.DetalleCajeroDTO;
import com.digis01.ISanchezPruebaCajero.JPA.Cajero;
import com.digis01.ISanchezPruebaCajero.JPA.DetalleCajero;
import com.digis01.ISanchezPruebaCajero.JPA.Result;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CajeroService {

    private final CajeroRepository cajeroRepository;
    private final DetalleCajeroRepository detalleCajeroRepository;

    public CajeroService(CajeroRepository cajeroRepository, DetalleCajeroRepository detalleCajeroRepository) {
        this.cajeroRepository = cajeroRepository;
        this.detalleCajeroRepository = detalleCajeroRepository;
    }

    public Result getMontoCajero(int id) {

        Result result = new Result();

        try {

            BigDecimal monto = cajeroRepository.getMontoCajero(id);
            result.object = monto;
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
        }
        return result;
    }

    public List<DetalleCajeroDTO> obtenerDetalleCajero(int idCajero) {

        List<DetalleCajero> rows = detalleCajeroRepository.getDetalleCajero(idCajero);
        List<DetalleCajeroDTO> result = new ArrayList<>();

        for (DetalleCajero row : rows) {
            DetalleCajeroDTO dto = new DetalleCajeroDTO();
            dto.setIdDenominacion(row.DenominacionDinero.getIdDenominacion());
            dto.setCantidadDinero(row.getCantidadDinero());
            dto.setIdTipo(row.TipoDinero.getIdTipo());
            dto.setIdCajero(row.Cajero.getIdCajero());
            dto.setMontoDenominacion(row.DenominacionDinero.getMontoDenominacion());

            result.add(dto);
        }
        return result;
    }

    @Transactional
    public Result RetirarDinero(int idUsuario, int idCajero, BigDecimal monto) {
        Result result = new Result();

        try {
            Map<String, Object> resp = cajeroRepository.retirarDinero(idUsuario, idCajero, monto);
            result.object = resp.get("pMensaje");

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
        }

        return result;
    }

    @Transactional
    public Result llenarCajero(int idUsuario, int idCajero, int idDenominacion, int cantidad) {
        Result result = new Result();

        try {
            Map<String, Object> resp = cajeroRepository.llenarCajero(
                    idUsuario,
                    idCajero,
                    idDenominacion,
                    cantidad
            );

            result.correct = true;
            result.object = resp.get("pMensaje");

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
        }

        return result;
    }
    
    public Result obtenerCajeros() {
        Result result = new Result();

        try {
            List<Cajero> cajeros = cajeroRepository.getCajeros();
            result.object = new ArrayList<>(cajeros);
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
        }

        return result;
    }
}
