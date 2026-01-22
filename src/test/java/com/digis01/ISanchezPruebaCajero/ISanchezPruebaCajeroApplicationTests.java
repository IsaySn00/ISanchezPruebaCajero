package com.digis01.ISanchezPruebaCajero;

import com.digis01.ISanchezPruebaCajero.Service.CuentaService;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ISanchezPruebaCajeroApplicationTests {

        @Autowired
        private CuentaService cuentaService;
    
	@Test
	void contextLoads() {
	}
        
        @Test
        public void testMontoUsuario(){
            int id = 1;
            
            BigDecimal monto = (BigDecimal) cuentaService.getMontoUsuario(id).object;
            
            assertThat(monto).isNotNull();
                    
        }

}
