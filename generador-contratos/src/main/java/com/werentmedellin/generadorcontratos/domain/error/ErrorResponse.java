package com.werentmedellin.generadorcontratos.domain.error;

import java.util.Date;
import java.util.List;

public class ErrorResponse {

    private int status;
    private String message;
    private Date fecha;
    private List<ErrorBody> errores;

    
    public ErrorResponse(int status, String message, Date fecha, List<ErrorBody> errores) {
        this.status = status;
        this.message = message;
        this.fecha = fecha;
        this.errores = errores;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public List<ErrorBody> getErrores() {
        return errores;
    }
    public void setErrores(List<ErrorBody> errores) {
        this.errores = errores;
    }

    
}
