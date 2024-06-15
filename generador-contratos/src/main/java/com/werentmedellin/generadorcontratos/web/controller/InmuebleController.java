package com.werentmedellin.generadorcontratos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.werentmedellin.generadorcontratos.domain.dto.AgenciaDTO;
import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.domain.dto.InmuebleDTO;
import com.werentmedellin.generadorcontratos.domain.error.ErrorBody;
import com.werentmedellin.generadorcontratos.domain.error.ErrorResponse;
import com.werentmedellin.generadorcontratos.domain.service.ContratoService;
import com.werentmedellin.generadorcontratos.domain.service.InmuebleService;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;

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
@RequestMapping("/inmueble")
public class InmuebleController {

    @Autowired
    InmuebleService inmuebleService;

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarInmueble(@RequestParam("municipio") String valor){
        List<InmuebleDTO> inmuebles= inmuebleService.buscarInmueble(valor);
        if(inmuebles == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"No existe un inmueble con este canon",new Date(),new ArrayList<ErrorBody>()));
        }else{
            return ResponseEntity.ok().body(inmuebles);  
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerInmueble(@PathVariable Long id){
        InmuebleDTO inmueble= inmuebleService.obtenerInmueble(id);
        if(inmueble == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"No existe un contrato con este identificador",new Date(),new ArrayList<ErrorBody>()));
        }else{
            return ResponseEntity.ok().body(inmueble);  
        }
    }

    @GetMapping()
    public ResponseEntity<?> obtenerInmuebles(){
        List<InmuebleDTO> inmuebles= inmuebleService.obtenerInmuebles();
        if(inmuebles.isEmpty()){
            return ResponseEntity.ok().body("No existen inmuebles");
        }else{
            return ResponseEntity.ok().body(inmuebles);  
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearInmueble(@Valid @RequestBody InmuebleDTO inmueble){
        try{
            List<InmuebleDTO> inmuebles = inmuebleService.crearInmueble(inmueble);
            if(inmuebles.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"",new Date(),new ArrayList<ErrorBody>()));
            }else{
                return ResponseEntity.status(HttpStatus.CREATED).body((inmuebles));
            }

        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e);
        }
       
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarInmueble(@Valid @RequestBody InmuebleDTO inmuebleDTO){
        try{
           List<InmuebleDTO> inmuebles = inmuebleService.eliminarInmueble(inmuebleDTO);
            if(inmuebles.equals(null)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"",new Date(),new ArrayList<ErrorBody>()));
            }else{
                return ResponseEntity.status(HttpStatus.CREATED).body((inmuebles));
            }

        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e);
        }
       
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarInmueble(@PathVariable Long id, @RequestBody InmuebleDTO inmueble) {
        try {
                if (inmueble == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body((ErrorResponse) new ErrorResponse(400, "", new Date(), new ArrayList<ErrorBody>()));
            } else {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body((inmuebleService.actualizarInmueble(id, inmueble)));
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }

    


}
