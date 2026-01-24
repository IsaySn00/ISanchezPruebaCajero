package com.digis01.ISanchezPruebaCajero.Service;

import com.digis01.ISanchezPruebaCajero.DAO.CuentaRepository;
import com.digis01.ISanchezPruebaCajero.JPA.Result;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;
    
    public CuentaService(CuentaRepository cuentaRepository){
        this.cuentaRepository = cuentaRepository;
    }
    
    public Result getMontoUsuario(int id){
        
        Result result = new Result();
              
        try{
        
            BigDecimal monto = cuentaRepository.getMontoCuentaUsuario(id);
            result.object = monto;
            result.correct = true;
            
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
        }
        return result;
    }
    
    
}
