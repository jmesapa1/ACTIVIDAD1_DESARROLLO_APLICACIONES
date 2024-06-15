package com.werentmedellin.generadorcontratos.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.domain.dto.PropietarioDTO;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;


@Component
public class PropietarioMapper {

    @Autowired
    CuentaMapper cuentaMapper;

    @Autowired
    ContratoMapper contratoMapper;

    public PropietarioDTO toPropietarioDTO(Propietario propietario) {
        if (propietario == null) {
            return null;
        }

        PropietarioDTO propietarioDTO = new PropietarioDTO();

        if (propietario.getId() != null) {
            propietarioDTO.setIdPropietario(propietario.getIdPropietario());
        }

        propietarioDTO.setPrimerNombre(propietario.getPrimerNombre());
        propietarioDTO.setSegundoNombre(propietario.getSegundoNombre());
        propietarioDTO.setPrimerApellido(propietario.getPrimerApellido());
        propietarioDTO.setPrimerApellido(propietario.getPrimerApellido());
        propietarioDTO.setCedula(propietario.getCedula());
        propietarioDTO.setCuenta(cuentaMapper.toCuentaDTO(propietario.getCuenta()));
        if (propietario.getContratos() != null) {
        }
        return propietarioDTO;    
    }

    public Propietario toPropietario(PropietarioDTO propietarioDTO) {
        if (propietarioDTO == null) {
            return null;
        }

        Propietario propietario = new Propietario();

        if (propietarioDTO.getIdPropietario() != null) {
            propietario.setId(propietarioDTO.getIdPropietario());
        }

        propietario.setPrimerNombre(propietarioDTO.getPrimerNombre());
        propietario.setSegundoNombre(propietarioDTO.getSegundoNombre());
        propietario.setPrimerApellido(propietarioDTO.getPrimerApellido());
        propietario.setSegundoApellido(propietarioDTO.getSegundoApellido());
        propietario.setCedula(propietarioDTO.getCedula());
        propietario.setCuenta(cuentaMapper.toCuenta(propietarioDTO.getCuenta()));
        if (propietarioDTO.getContratos() != null) {
        List<Contrato> contratos = new ArrayList<>(); 
        propietarioDTO.getContratos().forEach(contrato->{
            contratos.add(contratoMapper.toContrato(contrato));
        });
        propietario.setContratos(contratos); 
    }
        return propietario;    
    }

}
