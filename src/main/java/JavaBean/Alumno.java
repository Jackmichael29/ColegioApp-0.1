/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import Utilities.Validator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class Alumno {
    private int alumno_id;
    private String nombres;
    private String apellido_materno;
    private String apellido_paterno;
    private String dni;
    private LocalDate fecha_nacimiento;
    private String correo_electrico;
    private String apellidosNombres;
    private ArrayList<HistorialNotas> hnotas = new ArrayList<>();
    private HistorialNotas hnot = new HistorialNotas();
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public Alumno() {
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id){
        this.alumno_id = alumno_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre){
        if( (nombre==null) || (nombre.isEmpty()) ){
            errores.put("nombres", "El campo Nombre no puede estar vacio");  
            return;
        }
        if(nombre.length() > 20){
            errores.put("nombres", "El campo Nombre no puede sobrepasar los 20 carácteres");
            return;
        }
        this.nombres = nombre;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno){
        if( (apellido_materno==null) || (apellido_materno.isEmpty()) ){
            errores.put("apellido_materno", "El campo Apellido Materno no puede estar vacio");
            return;
        }
        if(apellido_materno.length() > 20){
            errores.put("apellido_materno", "El campo Apellido Materno no puede sobrepasar los 20 carácteres");
            return;
        }
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno){
        //no puede ser vacio
        if( (apellido_paterno==null) || (apellido_paterno.isEmpty()) ){
            errores.put("apellido_paterno", "El campo Apellido Paterno no puede estar vacio");  
            return;
        }
        if(apellido_paterno.length() > 20){
            errores.put("apellido_paterno", "El campo Apellido Paterno no puede sobrepasar los 20 carácteres");
            return;
        }
        this.apellido_paterno = apellido_paterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni){
        if(dni==null || dni.isEmpty()){
            errores.put("dni", "El campo DNI no puede estar en blanco");
            return;
        }
        if(!Validator.isDNI(dni)){
            errores.put("dni", "Error en el formato de DNI");
            return;
        }        
        this.dni = dni;
    }

    public LocalDate getFecha_nacimiento() {
        //no puede ser vacio
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento){
        if( fecha_nacimiento == null || fecha_nacimiento == LocalDate.MIN){
            errores.put("fecha_nacimiento", "El campo Fecha de Nacimiento esta vacio");
            return;
        }
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo_electrico() {
        return correo_electrico;
    }

    public void setCorreo_electrico(String correo_electrico){
        if( correo_electrico ==null || correo_electrico.isEmpty() ){
            errores.put("correo_electronico", "El campo Correo Electronico no puede estar vacia");
            return;
        }
        if(correo_electrico.length() > 50) {
            errores.put("correo_electronico", "El campo Correo Electronico no puede sobrepasar los 50 caracteres");
            return;
        }
        if(!Validator.isCorreoElectronico(correo_electrico)){
            errores.put("correo_electronico", "Error en el formato del Correo Electronico");
            return;
        }
        this.correo_electrico = correo_electrico;
    }

    public String getApellidosNombres() {
        return apellidosNombres;
    }

    public void setApellidosNombres(String apellidosNombres) {
        this.apellidosNombres = apellidosNombres;
    }     

    public ArrayList<HistorialNotas> getHnotas() {
        return hnotas;
    }

    public void setHnotas(ArrayList<HistorialNotas> hnotas) {
        this.hnotas = hnotas;
    }    
    
    public void agregarHnotas(HistorialNotas hn){
        this.hnotas.add(hn);
    }

    public HistorialNotas getHnot() {
        return hnot;
    }

    public void setHnot(HistorialNotas hnot) {
        this.hnot = hnot;
    }
}
