package com.digis01.ISanchezPruebaCajero.Service;

import com.digis01.ISanchezPruebaCajero.DAO.CajeroRepository;
import com.digis01.ISanchezPruebaCajero.DAO.DetalleCajeroRepository;
import com.digis01.ISanchezPruebaCajero.DTO.DetalleCajeroDTO;
import com.digis01.ISanchezPruebaCajero.JPA.DetalleCajero;
import com.digis01.ISanchezPruebaCajero.JPA.Result;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CajeroService {

    private final CajeroRepository cajeroRepository;
    private final DetalleCajeroRepository detalleCajeroRepository;
    
    public CajeroService(CajeroRepository cajeroRepository, DetalleCajeroRepository detalleCajeroRepository){
        this.cajeroRepository = cajeroRepository;
        this.detalleCajeroRepository = detalleCajeroRepository;
    }
    
    public Result getMontoCajero(int id){
        
        Result result = new Result();
              
        try{
        
            BigDecimal monto = cajeroRepository.getMontoCajero(id);
            result.object = monto;
            result.correct = true;
            
        }catch(Exception ex){
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
            dto.setIdDenominacion(((Number) row[0]).intValue());
            dto.setCantidadDinero(row.getCantidadDinero());
            dto.setIdTipo(((Number) row[2]).intValue());
            dto.setIdCajero(((Number) row[3]).intValue());
            dto.setMontoDenominacion((BigDecimal) row[4]);

            result.add(dto);
        }
        return result;
    }
}
