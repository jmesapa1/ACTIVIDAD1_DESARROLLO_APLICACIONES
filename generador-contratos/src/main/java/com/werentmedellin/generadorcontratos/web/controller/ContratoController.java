package com.werentmedellin.generadorcontratos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.werentmedellin.generadorcontratos.domain.dto.AgenciaDTO;
import com.werentmedellin.generadorcontratos.domain.dto.ContratoDTO;
import com.werentmedellin.generadorcontratos.domain.error.ErrorBody;
import com.werentmedellin.generadorcontratos.domain.error.ErrorResponse;
import com.werentmedellin.generadorcontratos.domain.service.ContratoService;
import com.werentmedellin.generadorcontratos.persistence.entity.Contrato;

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
@RequestMapping("/contrato")
public class ContratoController {

    @Autowired
    ContratoService contratoService;

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarAgencia(@RequestParam("valor") Long valor){
        List<ContratoDTO> contratos= contratoService.buscarContrato(valor);
        if(contratos == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"No existe una agencia con este identificador",new Date(),new ArrayList<ErrorBody>()));
        }else{
            return ResponseEntity.ok().body(contratos);  
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerContraro(@PathVariable Long id){
        ContratoDTO contrato= contratoService.obtenerContrato(id);
        if(contrato == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((ErrorResponse) new ErrorResponse(400,"No existe un contrato con este identificador",new Date(),new ArrayList<ErrorBody>()));
        }else{
            return ResponseEntity.ok().body(contrato);  
        }
    }

    @GetMapping()
    public ResponseEntity<?> obtenerContratos() {
        List<ContratoDTO> contratos = contratoService.obtenerContratos();
        if (contratoService.obtenerContratos() == null) {
            return ResponseEntity.ok().body("No existen contratos");
        } else {
            return ResponseEntity.ok().body(contratos);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearContratos(@Valid @RequestBody ContratoDTO contrato) {
        try {
            ContratoDTO contratoSaved = contratoService.crearContrato(contrato);
            if (contrato.equals(null)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body((ErrorResponse) new ErrorResponse(400, "", new Date(), new ArrayList<ErrorBody>()));
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body((contratoSaved));
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarContrato(@Valid @RequestBody ContratoDTO contrato) {
        try {
            List<ContratoDTO> contratos = contratoService.eliminarContrato(contrato);
            if (contrato.equals(null)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body((ErrorResponse) new ErrorResponse(400, "", new Date(), new ArrayList<ErrorBody>()));
            } else {
                return ResponseEntity.status(HttpStatus.CREATED).body((contratos));
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarContrato(@PathVariable Long id, @RequestBody ContratoDTO contrato) {
        try {
            if (contrato == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body((ErrorResponse) new ErrorResponse(400, "", new Date(), new ArrayList<ErrorBody>()));
            } else {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body((contratoService.actualizarContrato(id, contrato)));
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }
}
