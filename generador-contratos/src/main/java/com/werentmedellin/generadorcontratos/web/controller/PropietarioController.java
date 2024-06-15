package com.werentmedellin.generadorcontratos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.domain.dto.InmuebleDTO;
import com.werentmedellin.generadorcontratos.domain.dto.PropietarioDTO;
import com.werentmedellin.generadorcontratos.domain.error.ErrorBody;
import com.werentmedellin.generadorcontratos.domain.error.ErrorResponse;
import com.werentmedellin.generadorcontratos.domain.service.ContratoService;
import com.werentmedellin.generadorcontratos.domain.service.InmuebleService;
import com.werentmedellin.generadorcontratos.domain.service.PropietarioService;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    PropietarioService propietarioService;


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPropietario(@PathVariable Long id){
        PropietarioDTO propietario= propietarioService.obtenerPropietarioId(id);
        if(propietario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"No existe un propietario con este identificador",new Date(),new ArrayList<ErrorBody>()));
        }else{
            return ResponseEntity.ok().body(propietario);  
        }
    }

    @GetMapping()
    public ResponseEntity<?> obtenerPropietarios(){
        List<PropietarioDTO> propietarios= propietarioService.obtenerPropietario();
        if(propietarios.isEmpty()){
            return ResponseEntity.ok().body("No existen inmuebles");
        }else{
            return ResponseEntity.ok().body(propietarios);  
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearPropietario(@Valid @RequestBody PropietarioDTO propietarioDto){
        try{
            PropietarioDTO propietario = propietarioService.crearPropietario(propietarioDto);
            if(propietario != null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"",new Date(),new ArrayList<ErrorBody>()));
            }else{
                return ResponseEntity.status(HttpStatus.CREATED).body((propietario));
            }

        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e);
        }
       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPropietario(@Valid @RequestBody PropietarioDTO propietarioDTO){
        try{
           List<PropietarioDTO> propietarios = propietarioService.eliminarPropietario(propietarioDTO);
            if(propietarios.equals(null)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"",new Date(),new ArrayList<ErrorBody>()));
            }else{
                return ResponseEntity.status(HttpStatus.CREATED).body((propietarios));
            }

        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e);
        }
       
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPropietario(@PathVariable Long id, @RequestBody PropietarioDTO propietario) {
        try {
                if (propietario == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body((ErrorResponse) new ErrorResponse(400, "", new Date(), new ArrayList<ErrorBody>()));
            } else {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body((propietarioService.actualizarPropietario(id, propietario)));
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }

}
