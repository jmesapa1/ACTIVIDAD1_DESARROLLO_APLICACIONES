package com.werentmedellin.generadorcontratos.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.werentmedellin.generadorcontratos.domain.dto.AgenciaDTO;
import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.domain.dto.InmuebleDTO;
import com.werentmedellin.generadorcontratos.domain.dto.PropietarioDTO;
import com.werentmedellin.generadorcontratos.persistence.crud.InmuebleRepository;
import com.werentmedellin.generadorcontratos.persistence.crud.PropietarioRepository;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;
import com.werentmedellin.generadorcontratos.persistence.mapper.InmuebleMapper;
import com.werentmedellin.generadorcontratos.persistence.mapper.PropietarioMapper;

@Service
public class InmuebleService {

    @Autowired
    InmuebleRepository repository;
    @Autowired
    InmuebleMapper mapper;
    @Autowired
    PropietarioService propietarioService;
    @Autowired
    PropietarioMapper propietarioMapper;

    public List<InmuebleDTO> buscarInmueble(String valor){
        List<InmuebleDTO> inmuebles = new ArrayList<InmuebleDTO>();
        this.repository.findByMunicipio(valor).forEach(x -> inmuebles.add( mapper.toInmuebleDto(x)));
        return inmuebles;
    }


    public InmuebleDTO obtenerInmueble(Long id) {
        return mapper.toInmuebleDto(this.repository.findById(id).get());
    }

    public List<InmuebleDTO> obtenerInmuebles() {
        List<InmuebleDTO> inmuebles = new ArrayList<InmuebleDTO>();
        this.repository.findAll().forEach(x -> inmuebles.add( mapper.toInmuebleDto(x)));
        return inmuebles;
    }

    public List<InmuebleDTO> crearInmueble(InmuebleDTO inmuebleDTO) { 

        Inmueble inmueble = new Inmueble();
        inmueble=mapper.toInmueble(inmuebleDTO);
        this.repository.save(inmueble);
       
        if (inmueble instanceof Inmueble) {
           return obtenerInmuebles();
        }else{
            return null;
        }
    }

    public List<InmuebleDTO> eliminarInmueble(InmuebleDTO inmuebleDTO) {
        if(inmuebleDTO.getIdInmueble()!=null){
            repository.delete(mapper.toInmueble(inmuebleDTO));
        }
        return obtenerInmuebles();
    }

     public InmuebleDTO actualizarInmueble(Long id, InmuebleDTO inmuebleDto) {
        if(id!=null){
            Inmueble i = repository.findById(id).get();

            i.setDireccion(inmuebleDto.getDireccion());
            i.setApartamento(inmuebleDto.getApartamento());
            i.setApartamentoFlag(inmuebleDto.getApartamentoFlag());
            i.setApartamento(inmuebleDto.getApartamento());
            i.setCasaFlag(inmuebleDto.getCasaFlag());
            i.setCasa(inmuebleDto.getCasa());
            i.setUrbanizacionFlag(inmuebleDto.getUrbanizacionFlag());
            i.setUrbanizacion(inmuebleDto.getUrbanizacion());
            i.setParqueaderoFlag(inmuebleDto.getParqueaderoFlag());
            i.setCuartoUtilFlag(inmuebleDto.getCuartoUtilFlag());
            i.setCuartoUtil(inmuebleDto.getCuartoUtil());
            i.setCuartoUtilFlag(inmuebleDto.getCuartoUtilFlag());
            i.setCuartoUtil(inmuebleDto.getCuartoUtil());
            i.setMunicipio(inmuebleDto.getMunicipio());
            i.setDepartamento(inmuebleDto.getDepartamento());

            return mapper.toInmuebleDto(repository.save(i));
        }else{
            return null;
        }
    }
}
