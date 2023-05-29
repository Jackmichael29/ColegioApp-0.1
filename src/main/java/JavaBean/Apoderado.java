/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import Utilities.Validator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author black
 */
public class Apoderado {
    private int apoderado_id;
    private String nombres;
    private String apellido_materno;
    private String apellido_paterno;
    private String dni;
    
    private String contacto;
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
    
    public Apoderado() {
    }

    public int getApoderado_id() {
        return apoderado_id;
    }

    public void setApoderado_id(int apoderado_id){
        this.apoderado_id = apoderado_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre){
        if( (nombre==null) || (nombre.isEmpty()) ){
            errores.put("nombres", "El campo Nombres no puede estar vacío");
            return;        
        }
        if(nombre.length() > 20){
            errores.put("nombres", "El campo Nombres no puede sobrepasar los 20 caracteres");
            return;   
        }
        this.nombres = nombre;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno){
        if( apellido_materno==null || apellido_materno.isEmpty()){
            errores.put("apellido_materno", "El campo Apellido Materno no puede estar vacío");
            return;
        }
        if(apellido_materno.length() > 20){
            errores.put("apellido_materno", "El campo Apellido Materno no puede sobrepasar los 20 caracteres");
            return;
        }
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno){
        if( apellido_paterno==null || apellido_paterno.isEmpty()){
            errores.put("apellido_paterno", "El campo Apellido Paterno no puede estar vacío");
            return;
        }
        if(apellido_paterno.length() > 20){
            errores.put("apellido_paterno", "El campo Apellido Paterno no puede sobrepasar los 20 caracteres");
            return;
        }     
        this.apellido_paterno = apellido_paterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni){
        if(dni==null ||dni.isEmpty()){
            errores.put("dni", "El campo DNI no puede estar vacío");
            return;
        }
            
        if(!Validator.isDNI(dni)){
            errores.put("dni", "Error en el formato de DNI");
            return;
        }       
        this.dni = dni;
    }
    
     public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto){
        if(contacto==null ||contacto.isEmpty()){
            errores.put("contacto", "El campo Contacto no puede estar en blanco");
            return;
        }
        if(!Validator.isNumeroTelefono(contacto)){
            errores.put("contacto", "Error en el formato Contacto");
            return; 
        }
        this.contacto = contacto;
    }
    
}
