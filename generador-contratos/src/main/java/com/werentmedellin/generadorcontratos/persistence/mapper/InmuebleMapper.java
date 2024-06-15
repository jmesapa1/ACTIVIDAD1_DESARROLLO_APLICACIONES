package com.werentmedellin.generadorcontratos.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.domain.dto.InmuebleDTO;
import com.werentmedellin.generadorcontratos.domain.dto.PropietarioDTO;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;

@Component
public class InmuebleMapper {

    @Autowired
    PropietarioMapper propietarioMapper;

    @Autowired
    ContratoMapper contratoMapper;

    

    public InmuebleDTO toInmuebleDto(Inmueble inmueble) {
        if (inmueble == null) {
            return null;
        }

        InmuebleDTO inmuebleDTO = new InmuebleDTO();

        if (inmueble.getIdInmueble() != null) {
            inmuebleDTO.setIdInmueble(inmueble.getIdInmueble());
        }

        inmuebleDTO.setDireccion(inmueble.getDireccion());
        inmuebleDTO.setApartamento(inmueble.getApartamento());
        inmuebleDTO.setApartamentoFlag(inmueble.getApartamentoFlag());
        inmuebleDTO.setApartamento(inmueble.getApartamento());
        inmuebleDTO.setCasaFlag(inmueble.getCasaFlag());
        inmuebleDTO.setCasa(inmueble.getCasa());
        inmuebleDTO.setUrbanizacionFlag(inmueble.getUrbanizacionFlag());
        inmuebleDTO.setUrbanizacion(inmueble.getUrbanizacion());
        inmuebleDTO.setParqueaderoFlag(inmueble.getParqueaderoFlag());
        inmuebleDTO.setCuartoUtilFlag(inmueble.getCuartoUtilFlag());
        inmuebleDTO.setCuartoUtil(inmueble.getCuartoUtil());
        inmuebleDTO.setCuartoUtilFlag(inmueble.getCuartoUtilFlag());
        inmuebleDTO.setCuartoUtil(inmueble.getCuartoUtil());
        inmuebleDTO.setMunicipio(inmueble.getMunicipio());
        inmuebleDTO.setDepartamento(inmueble.getDepartamento());
        return inmuebleDTO;
    }

    public Inmueble toInmueble(InmuebleDTO inmuebleDto) {
        if (inmuebleDto == null) {
            return null;
        }

        Inmueble inmueble = new Inmueble();

        if (inmuebleDto.getIdInmueble() != null) {
            inmueble.setIdInmueble(inmuebleDto.getIdInmueble());
        }

        inmueble.setDireccion(inmuebleDto.getDireccion());
        inmueble.setApartamento(inmuebleDto.getApartamento());
        inmueble.setApartamentoFlag(inmuebleDto.getApartamentoFlag());
        inmueble.setApartamento(inmuebleDto.getApartamento());
        inmueble.setCasaFlag(inmuebleDto.getCasaFlag());
        inmueble.setCasa(inmuebleDto.getCasa());
        inmueble.setUrbanizacionFlag(inmuebleDto.getUrbanizacionFlag());
        inmueble.setUrbanizacion(inmuebleDto.getUrbanizacion());
        inmueble.setParqueaderoFlag(inmuebleDto.getParqueaderoFlag());
        inmueble.setCuartoUtilFlag(inmuebleDto.getCuartoUtilFlag());
        inmueble.setCuartoUtil(inmuebleDto.getCuartoUtil());
        inmueble.setCuartoUtilFlag(inmuebleDto.getCuartoUtilFlag());
        inmueble.setCuartoUtil(inmuebleDto.getCuartoUtil());
        inmueble.setMunicipio(inmuebleDto.getMunicipio());
        inmueble.setDepartamento(inmuebleDto.getDepartamento());
        List<Contrato> contratos = new ArrayList<>();
        if (inmuebleDto.getContratos() != null) {
            inmuebleDto.getContratos().forEach(contrato -> {
                contratos.add(contratoMapper.toContrato(contrato));
            });
            inmueble.setContratos(contratos);
        }
        return inmueble;
    }

}
