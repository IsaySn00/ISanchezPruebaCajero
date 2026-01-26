package com.digis01.ISanchezPruebaCajero.Service;

import com.digis01.ISanchezPruebaCajero.DAO.DenominacionDineroRepository;
import com.digis01.ISanchezPruebaCajero.JPA.Result;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class DenominacionDineroService {
    
    private final DenominacionDineroRepository denominacionRepository;
    
    public DenominacionDineroService(DenominacionDineroRepository denominacionDineroRepository){
        this.denominacionRepository = denominacionDineroRepository;
    }
    
    public Result getDenominacion(){
        Result result = new Result();
        
        try{
            result.object = new ArrayList<>(denominacionRepository.getDenominaciones());
            result.correct = true;
            
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            
        }
        return result;
    }
}
