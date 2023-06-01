/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author black
 */
public class pagoPensiones {
    
    private int pago_pensiones_id;
    private LocalDate fecha;
    private double monto;
    private String observacion;
    
    private int alumno_id;
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }
    
    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public pagoPensiones(){
    }

    public int getPago_pensiones_id() {
        return pago_pensiones_id;
    }

    public void setPago_pensiones_id(int pago_pensiones_id) {
        this.pago_pensiones_id = pago_pensiones_id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha){
        if(fecha == null || fecha.equals(LocalDate.MIN) ){
            errores.put("fecha","La fecha está vacía o no ha sido inicializada");
        }
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto){
        if(monto <= 0){
            errores.put("monto","El monto debe ser mayor a 0");
        }
        this.monto = monto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion){
        if(observacion == null || observacion.isEmpty()){
            errores.put("observacion","El campo observacion no debe estar vacia");
        }
        this.observacion = observacion;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }
}
