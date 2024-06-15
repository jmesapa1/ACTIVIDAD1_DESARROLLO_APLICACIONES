package com.werentmedellin.generadorcontratos.persistence.mapper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.persistence.entity.Agencia;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Component
public class ContratoMapper {

    @Autowired
    InmuebleMapper inmuebleMapper;
    @Autowired
    PropietarioMapper propietarioMapper;
    @Autowired
    AgenciaMapper agenciaMapper;

    public ContratoDTO toContratoDto(Contrato contrato) {
        if ( contrato == null ) {
            return null;
        }

        ContratoDTO contratoDTO = new ContratoDTO();

        if ( contrato.getId() != null ) {
            contratoDTO.setId(contrato.getId() );
        }

        contratoDTO.setFechaCreacion(contrato.getFechaCreacion());
        contratoDTO.setFechaInicio(contrato.getFechaInicio());
        contratoDTO.setFechaFin(contrato.getFechaFin());
        contratoDTO.setCanon(contrato.getCanon());
        contratoDTO.setComision(contrato.getComision());
        contratoDTO.setDuracionMeses(contrato.getDuracionMeses());
        contratoDTO.setAgencia(agenciaMapper.toAgenciaDTO(contrato.getAgencia()));
        contratoDTO.setPropietario(propietarioMapper.toPropietarioDTO(contrato.getPropietario()));
        contratoDTO.setInmueble(inmuebleMapper.toInmuebleDto(contrato.getInmueble()));

        return contratoDTO;
    }

    public Contrato toContrato(ContratoDTO contratoDto) {
        if ( contratoDto == null ) {
            return null;
        }
        Contrato contrato = new Contrato();
        if ( contratoDto.getId() != null ) {
            contrato.setId(contratoDto.getId() );
        }
        contrato.setFechaCreacion(contratoDto.getFechaCreacion());
        contrato.setFechaInicio(contratoDto.getFechaInicio());
        contrato.setFechaFin(contratoDto.getFechaFin());
        contrato.setCanon(contratoDto.getCanon());
        contrato.setComision(contratoDto.getComision());
        contrato.setDuracionMeses(contratoDto.getDuracionMeses());
        contrato.setInmueble(inmuebleMapper.toInmueble(contratoDto.getInmueble()));
        contrato.setPropietario(propietarioMapper.toPropietario(contratoDto.getPropietario()));
        contrato.setAgencia(agenciaMapper.toAgencia(contratoDto.getAgencia()));

        return contrato;
    }

}
