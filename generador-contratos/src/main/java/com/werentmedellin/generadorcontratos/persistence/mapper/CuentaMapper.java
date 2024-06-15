package com.werentmedellin.generadorcontratos.persistence.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.werentmedellin.generadorcontratos.domain.dto.CuentaDTO;
import com.werentmedellin.generadorcontratos.domain.dto.InmuebleDTO;
import com.werentmedellin.generadorcontratos.domain.dto.PropietarioDTO;
import com.werentmedellin.generadorcontratos.persistence.entity.Cuenta;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;

import jakarta.persistence.Column;

@Component
public class CuentaMapper {

    public CuentaDTO toCuentaDTO(Cuenta cuenta) {
        if (cuenta == null) {
            return null;
        }

        CuentaDTO cuentaDTO = new CuentaDTO();

        if (cuenta.getId() != null) {
            cuentaDTO.setId(cuenta.getId());
        }

        cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
    
        return cuentaDTO;    
    }

    public Cuenta toCuenta(CuentaDTO cuentaDTO) {
        if (cuentaDTO == null) {
            return null;
        }

        Cuenta cuenta = new Cuenta();

        if (cuenta.getId() != null) {
            cuenta.setId(cuentaDTO.getId());
        }

        cuenta.setNumeroCuenta(cuentaDTO.getNumeroCuenta());
        

        return cuenta;    
    }

}
