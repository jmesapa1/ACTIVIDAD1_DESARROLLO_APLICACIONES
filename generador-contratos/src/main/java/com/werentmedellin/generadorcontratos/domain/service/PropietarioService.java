package com.werentmedellin.generadorcontratos.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.domain.dto.InmuebleDTO;
import com.werentmedellin.generadorcontratos.domain.dto.PropietarioDTO;
import com.werentmedellin.generadorcontratos.persistence.crud.PropietarioRepository;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;
import com.werentmedellin.generadorcontratos.persistence.mapper.CuentaMapper;
import com.werentmedellin.generadorcontratos.persistence.mapper.PropietarioMapper;

@Service
public class PropietarioService {

    @Autowired
    PropietarioRepository repository;
    @Autowired
    PropietarioMapper propietarioMapper;
    @Autowired
    CuentaMapper cuentaMapper;

    public List<PropietarioDTO> obtenerPropietario() {
        List<PropietarioDTO> propietariosDto = new ArrayList<>();
        this.repository.findAll().forEach(propietario -> propietariosDto.add(propietarioMapper.toPropietarioDTO(propietario)));
        return propietariosDto;
    }
    public PropietarioDTO obtenerPropietarioId(Long id) {
        return propietarioMapper.toPropietarioDTO(this.repository.findById(id).get());
    
    }

    public PropietarioDTO crearPropietario(PropietarioDTO propietarioDto) {
        Propietario propietario = this.repository.save(propietarioMapper.toPropietario(propietarioDto));
        return propietarioMapper.toPropietarioDTO(propietario);
    }

    public List<PropietarioDTO>  eliminarPropietario(PropietarioDTO propietarioDto) {
        if(propietarioDto.getIdPropietario()!=null){
            repository.delete(propietarioMapper.toPropietario(propietarioDto));
        }
        return obtenerPropietario();
    }

    public PropietarioDTO  actualizarPropietario(Long id, PropietarioDTO propietarioDto) {
        if(id!=null){
            Propietario propietario = repository.findById(id).get();
           
            propietario.setPrimerNombre(propietarioDto.getPrimerNombre());
            propietario.setSegundoNombre(propietarioDto.getSegundoNombre());
            propietario.setPrimerApellido(propietarioDto.getPrimerApellido());
            propietario.setPrimerApellido(propietarioDto.getPrimerApellido());
            propietario.setCedula(propietarioDto.getCedula());
            propietario.setCuenta(cuentaMapper.toCuenta(propietarioDto.getCuenta()));

            return propietarioMapper.toPropietarioDTO(repository.save(propietario));
        }else{
            return null;
        }
    }
}
