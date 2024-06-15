package com.werentmedellin.generadorcontratos.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.werentmedellin.generadorcontratos.domain.dto.AgenciaDTO;
import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.persistence.crud.ContratoRepository;
import com.werentmedellin.generadorcontratos.persistence.entity.Agencia;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;
import com.werentmedellin.generadorcontratos.persistence.mapper.ContratoMapper;
import com.werentmedellin.generadorcontratos.persistence.mapper.InmuebleMapper;
import com.werentmedellin.generadorcontratos.persistence.mapper.PropietarioMapper;

@Service
public class ContratoService {

    @Autowired
    ContratoRepository contratoRepository;

   @Autowired
   PropietarioMapper propietarioMapper;
   @Autowired
   InmuebleMapper inmuebleMapper;

    @Autowired
    ContratoMapper contratoMapper;

    public List<ContratoDTO> buscarContrato(Long valor){
        List<ContratoDTO> contratos = new ArrayList<ContratoDTO>();
        this.contratoRepository.findByCanon(valor).forEach(x -> contratos.add( contratoMapper.toContratoDto(x)));
        return contratos;
    }

    public ContratoDTO obtenerContrato(Long id) {
        return contratoMapper.toContratoDto(this.contratoRepository.findById(id).get());
    }

    public List<ContratoDTO> obtenerContratos() {
        List<ContratoDTO> contratos = new ArrayList<ContratoDTO>();
        this.contratoRepository.findAll().forEach(x -> contratos.add( contratoMapper.toContratoDto(x)));
        return contratos;
    }

    public ContratoDTO crearContrato(ContratoDTO contratoDto) {
        Contrato contrato = contratoMapper.toContrato(contratoDto);
        Inmueble i = contrato.getInmueble();
        contrato.setInmueble(i);
        Propietario p = contrato.getPropietario();
        contrato.setPropietario(p);

        if(p.getContratos() == null){
            p.setContratos(new ArrayList<>());
            p.getContratos().add(contrato);
        }

        if(i.getContratos()== null){
            i.setContratos(new ArrayList<>());
            i.getContratos().add(contrato);
        }
        
        return contratoMapper.toContratoDto(contratoRepository.save(contrato));
    }

    public List<ContratoDTO>  eliminarContrato(ContratoDTO contratoDto) {
        if(contratoDto.getId()!=null){
            contratoRepository.delete(contratoMapper.toContrato(contratoDto));
        }
        return obtenerContratos();
    }

    public ContratoDTO  actualizarContrato(Long id, ContratoDTO contratoDto) {
        if(id!=null){
            Contrato c = contratoRepository.findById(id).get();
            c.setCanon(contratoDto.getCanon());
            c.setComision(contratoDto.getComision());
            c.setFechaInicio(contratoDto.getFechaInicio());
            c.setFechaFin(contratoDto.getFechaFin());
            c.setFechaCreacion(contratoDto.getFechaCreacion());
            c.setDuracionMeses(contratoDto.getDuracionMeses());

            c.setPropietario(propietarioMapper.toPropietario(contratoDto.getPropietario()));
            c.setInmueble(inmuebleMapper.toInmueble(contratoDto.getInmueble()));
            return contratoMapper.toContratoDto(contratoRepository.save(c));
        }else{
            return null;
        }
    }

}
