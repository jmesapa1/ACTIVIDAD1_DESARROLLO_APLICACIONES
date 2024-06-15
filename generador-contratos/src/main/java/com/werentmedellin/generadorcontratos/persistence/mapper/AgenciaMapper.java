package com.werentmedellin.generadorcontratos.persistence.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.werentmedellin.generadorcontratos.domain.dto.AgenciaDTO;
import com.werentmedellin.generadorcontratos.domain.dto.InmuebleDTO;
import com.werentmedellin.generadorcontratos.domain.dto.PropietarioDTO;
import com.werentmedellin.generadorcontratos.persistence.entity.Agencia;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;

import jakarta.persistence.Column;

@Component
public class AgenciaMapper {

    public AgenciaDTO toAgenciaDTO(Agencia agencia) {
        if (agencia == null) {
            return null;
        }

        AgenciaDTO agenciaDTO = new AgenciaDTO();

        if (agencia.getId() != null) {
            agenciaDTO.setId(agencia.getId());
        }

        agenciaDTO.setNombre(agencia.getNombre());
        agenciaDTO.setNombreRepresentanteLegal(agencia.getNombreRepresentanteLegal());
        agenciaDTO.setTelefono(agencia.getTelefono());
        agenciaDTO.setNit(agencia.getNit());
        agenciaDTO.setDireccion(agencia.getDireccion());

        return agenciaDTO;    
    }

    public Agencia toAgencia(AgenciaDTO agenciaDTO) {
        if (agenciaDTO == null) {
            return null;
        }

        Agencia agencia = new Agencia();

        if (agenciaDTO.getId() != null) {
            agencia.setId(agenciaDTO.getId());
        }

        agencia.setNombre(agenciaDTO.getNombre());
        agencia.setNombreRepresentanteLegal(agenciaDTO.getNombreRepresentanteLegal());
        agencia.setTelefono(agenciaDTO.getTelefono());
        agencia.setNit(agenciaDTO.getNit());
        agencia.setDireccion(agenciaDTO.getDireccion());

        return agencia;    
    }

}
