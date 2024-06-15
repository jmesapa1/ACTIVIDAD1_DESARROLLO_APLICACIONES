package com.werentmedellin.generadorcontratos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.werentmedellin.generadorcontratos.domain.dto.AgenciaDTO;
import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.domain.dto.InmuebleDTO;
import com.werentmedellin.generadorcontratos.domain.dto.PropietarioDTO;
import com.werentmedellin.generadorcontratos.domain.error.ErrorBody;
import com.werentmedellin.generadorcontratos.domain.error.ErrorResponse;
import com.werentmedellin.generadorcontratos.domain.service.AgenciaService;
import com.werentmedellin.generadorcontratos.domain.service.ContratoService;
import com.werentmedellin.generadorcontratos.domain.service.InmuebleService;
import com.werentmedellin.generadorcontratos.domain.service.PropietarioService;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;
import com.werentmedellin.generadorcontratos.persistence.entity.Inmueble;
import com.werentmedellin.generadorcontratos.persistence.entity.Propietario;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController()
@RequestMapping("/agencia")
public class AgenciaController {

    @Autowired
    AgenciaService agenciaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAgecia(@PathVariable Long id){
        AgenciaDTO agencia= agenciaService.obtenerAgencia(id);
        if(agencia == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"No existe una agencia con este identificador",new Date(),new ArrayList<ErrorBody>()));
        }else{
            return ResponseEntity.ok().body(agencia);  
        }
    }
    @GetMapping()
    public ResponseEntity<?> obtenerAgecias(){
        List<AgenciaDTO> agencias= agenciaService.obtenerAgencias();
        if(agencias.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"No existen agencias",new Date(),new ArrayList<ErrorBody>()));
        }else{
            return ResponseEntity.ok().body(agencias);  
        }
    }
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarAgencia(@RequestParam("nombre") String valor){
        List<AgenciaDTO> agencia= agenciaService.buscarAgencia(valor);
        if(agencia == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"No existe una agencia con este identificador",new Date(),new ArrayList<ErrorBody>()));
        }else{
            return ResponseEntity.ok().body(agencia);  
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearAgencia(@Valid @RequestBody AgenciaDTO agenciaDto){
        try{
            AgenciaDTO agencia = agenciaService.crearAgencia(agenciaDto);
            if(agencia != null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"",new Date(),new ArrayList<ErrorBody>()));
            }else{
                return ResponseEntity.status(HttpStatus.CREATED).body((agencia));
            }

        }catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }
       
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarAgencia(@Valid @RequestBody AgenciaDTO agenciaDto){
        try{
           List<AgenciaDTO> contratos = agenciaService.eliminarAgencia(agenciaDto);
            if(contratos.equals(null)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"",new Date(),new ArrayList<ErrorBody>()));
            }else{
                return ResponseEntity.status(HttpStatus.CREATED).body((contratos));
            }

        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e);
        }  
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarAgencia(@PathVariable Long id, @RequestBody AgenciaDTO agencia) {
        try{
            if(agencia == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"",new Date(),new ArrayList<ErrorBody>()));
            }else{
                return ResponseEntity.status(HttpStatus.CREATED).body((agenciaService.actualizarAgencia(id, agencia)));
            }

        }catch(Exception e){
            return ResponseEntity.badRequest().body(e);
        }
       
    }
}
