package com.digis01.ISanchezPruebaCajero.Service;

import com.digis01.ISanchezPruebaCajero.DAO.CajeroRepository;
import com.digis01.ISanchezPruebaCajero.JPA.Result;
import org.springframework.stereotype.Service;

@Service
public class CajeroService {

    private final CajeroRepository cajeroRepository;
    
    public CajeroService(CajeroRepository cajeroRepository){
        this.cajeroRepository = cajeroRepository;
    }
    
    public Result getMontoCajero(int id){
        
        Result result = new Result();
              
        try{
        
            Long monto = cajeroRepository.getMontoCajero(id);
            result.object = monto / 100;
            result.correct = true;
            
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
        }
        return result;
    }
}
