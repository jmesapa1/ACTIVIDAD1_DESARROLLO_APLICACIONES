package com.werentmedellin.generadorcontratos.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.google.common.base.Optional;
import com.werentmedellin.generadorcontratos.domain.dto.AgenciaDTO;
import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.persistence.crud.AgenciaRepository;
import com.werentmedellin.generadorcontratos.persistence.entity.Agencia;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Cuenta;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;
import com.werentmedellin.generadorcontratos.persistence.mapper.AgenciaMapper;

@Service
public class AgenciaService {

    @Autowired
    AgenciaRepository repository;

    @Autowired
    AgenciaMapper agenciaMapper;

    
    public List<AgenciaDTO> buscarAgencia(String valor){
        List<AgenciaDTO> agencias = new ArrayList<AgenciaDTO>();
        this.repository.findByNombre(valor).forEach(x -> agencias.add( agenciaMapper.toAgenciaDTO(x)));
        return agencias;
    }

    public List<AgenciaDTO> obtenerAgencias() {
        List<AgenciaDTO> agencias = new ArrayList<AgenciaDTO>();
        this.repository.findAll().forEach(x -> agencias.add( agenciaMapper.toAgenciaDTO(x)));
        return agencias;
    }

    public AgenciaDTO obtenerAgencia(Long id) {
        return agenciaMapper.toAgenciaDTO(this.repository.findById(id).get());
    }

    public AgenciaDTO crearAgencia(AgenciaDTO agenciaDto) {
        Agencia agencia = agenciaMapper.toAgencia(agenciaDto);   
        return agenciaMapper.toAgenciaDTO(this.repository.save(agencia));
    }

    public List<AgenciaDTO>  eliminarAgencia(AgenciaDTO agenciaDto) {
        if(agenciaDto.getId()!=null){
            repository.delete(agenciaMapper.toAgencia(agenciaDto));
        }
        return obtenerAgencias();
    }
    public AgenciaDTO  actualizarAgencia(Long id, AgenciaDTO agenciaDto) {
        if(id!=null){
            Agencia a = repository.findById(id).get();
            a.setDireccion(agenciaDto.getDireccion());
            a.setNit(agenciaDto.getNit());
            a.setNombre(agenciaDto.getNombre());
            a.setNombreRepresentanteLegal(agenciaDto.getNombreRepresentanteLegal());
            a.setTelefono(agenciaDto.getTelefono());
            return agenciaMapper.toAgenciaDTO(repository.save(a));
        }else{
            return null;
        }
    }
}
