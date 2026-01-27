package com.digis01.ISanchezPruebaCajero.RestController;
import com.digis01.ISanchezPruebaCajero.JPA.Result;
import com.digis01.ISanchezPruebaCajero.Service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaRestController {

    @Autowired
    private CuentaService cuentaService;
    
    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('ROLE_usuario')")
    @GetMapping("/monto")
    public ResponseEntity GetMontoUsuario(@RequestParam int idUsuario){
        
        Result result = new Result();
        
        try{
            
            result.object = cuentaService.getMontoUsuario(idUsuario).object;
            result.correct = true;
            result.status = 201;
            
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.status = 500;
        }
        return ResponseEntity.status(result.status).body(result);
    }
}
