package com.digis01.ISanchezPruebaCajero.RestController;

import com.digis01.ISanchezPruebaCajero.DTO.LlenarCajeroDTO;
import com.digis01.ISanchezPruebaCajero.DTO.RetiroDTO;
import com.digis01.ISanchezPruebaCajero.JPA.Result;
import com.digis01.ISanchezPruebaCajero.Service.CajeroService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cajero")
public class CajeroRestController {

    @Autowired
    private CajeroService cajeroService;

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('ROLE_usuario')")
    @PostMapping("/retirar")
    public ResponseEntity RetirarDinero(@RequestBody RetiroDTO retiro) {
        Result result = new Result();

        try {
            Result resultSP = cajeroService.RetirarDinero(retiro.getIdUsuario(), retiro.getIdCajero(), retiro.getMonto());
            
            result.object = resultSP.object;
            result.correct = true;
            result.status = 201;
            result.SpStatus = resultSP.SpStatus;
            

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.status = 500;
        }
        return ResponseEntity.status(result.status).body(result);
    }

    @PreAuthorize("hasAuthority('ROLE_admin')")
    @PostMapping("/llenar")
    public ResponseEntity llenarCajero(@RequestBody LlenarCajeroDTO dto) {
        Result result = new Result();

        try {
            Result resultSP = cajeroService.llenarCajero(
                    dto.getIdUsuario(),
                    dto.getIdCajero(),
                    dto.getIdDenominacion(),
                    dto.getCantidad()
            );
            result.object = resultSP.object;
            result.SpStatus = resultSP.SpStatus;
            result.correct = true;
            result.status = 201;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.status = 500;
        }
        return ResponseEntity.status(result.status).body(result);
    }

    @PreAuthorize("hasAuthority('ROLE_admin') or hasAuthority('ROLE_usuario')")
    @GetMapping("/listar")
    public ResponseEntity listarCajeros() {
        Result result = new Result();

        try {
            result.object = cajeroService.obtenerCajeros().object;
            result.correct = true;
            result.status = 201;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.status = 500;
        }
        return ResponseEntity.status(result.status).body(result);

    }

}
