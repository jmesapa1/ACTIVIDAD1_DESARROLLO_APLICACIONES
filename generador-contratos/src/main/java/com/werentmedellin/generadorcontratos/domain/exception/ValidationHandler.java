package com.werentmedellin.generadorcontratos.domain.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.werentmedellin.generadorcontratos.domain.error.ErrorBody;
import com.werentmedellin.generadorcontratos.domain.error.ErrorResponse;

@RestControllerAdvice
public class ValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handle(MethodArgumentNotValidException ex){
        List<ErrorBody> errores = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error-> {
            ErrorBody err = new ErrorBody();
            err.setField(error.getField());
            err.setError(error.getDefaultMessage());
            errores.add(err);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(400,"Error en datos",new Date(),errores));
    }
 
}
