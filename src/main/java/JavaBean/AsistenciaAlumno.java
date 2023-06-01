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
public class AsistenciaAlumno {
    private int asistencia_alumno_id;
    private LocalDate fecha;
    private String Observacion;
    private int alumno_id;
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public AsistenciaAlumno(){
    }
    
    public int getAsistencia_alumno_id() {
        return asistencia_alumno_id;
    }

    public void setAsistencia_alumno_id(int asistencia_alumno_id) {
        this.asistencia_alumno_id = asistencia_alumno_id;
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

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    
    
}
