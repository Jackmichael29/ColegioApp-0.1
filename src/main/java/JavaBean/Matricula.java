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
 * @author LAB-USR-HUAN-A0305
 */
public class Matricula {
    
    private int matricula_id;
    private LocalDate fecha;
    private char grado;
    private char nivel;
    private char turno;
    private int alumno_id;
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public Matricula(){
    }

    public int getMatricula_id() {
        return matricula_id;
    }

    public void setMatricula_id(int matricula_id) {
        this.matricula_id = matricula_id;
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

    public char getGrado() {
        return grado;
    }

    public void setGrado(char grado){
        if(grado == ' '){
            errores.put("grado","El campo grado no puede estar vacio");
        }
        this.grado = grado;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel){
        if(nivel == ' '){
            errores.put("nivel","El campo nivel no puede estar vacio");
        }
        this.nivel = nivel;
    }

    public char getTurno() {
        return turno;
    }

    public void setTurno(char turno){
        if(turno == ' '){
            errores.put("turno","El campo turno no puede estar vacio");
        }
        this.turno = turno;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }
}
