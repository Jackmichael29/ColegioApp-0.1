/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class Curso {
    private int curso_id;
    private String nombre;
    private char nivel;
    private char grado;
    private int area_id;
    private Area area;
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public Curso() {
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        if( (nombre==null) || (nombre.isEmpty()) ){
            errores.put("nombres","El campo Nombre no puede estar vacio");
            return;
        }
        this.nombre = nombre;
    }

    public char getGrado(){
        return grado;
    }

    public void setGrado(char grado){
        if (grado == ' '){
            errores.put("grado","El campo grado no puede estar vacio");
            return;
        }
        this.grado = grado;
    }    

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel){
        if (nivel == ' '){
            errores.put("nivel","El campo nivel no puede estar vacio");
            return;
        }
        this.nivel = nivel;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
