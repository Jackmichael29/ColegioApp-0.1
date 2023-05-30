/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaBean;

import Utilities.Validator;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class Usuario {
    
    private int usuario_id;
    private String nombres;
    private String apellido_materno;
    private String apellido_paterno;
    private String dni;
    private String clave;
    private String rol;
    private String apellidosNombres;
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public Usuario(){
    }

    public Usuario(String nombres, String apellido_materno, String apellido_paterno, String dni, String clave, String rol) {
        this.nombres = nombres;
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.dni = dni;
        this.clave = clave;
        this.rol = rol;
    }

    
    
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        if (nombres == null || nombres.isEmpty()) {
            errores.put("nombres","El Nombre no puede estar vacío");
        }
        
        if (nombres.length() > 20) {
            errores.put("nombres","El Nombre no puede exxceder los 20 caracteres");
        }
        
        this.nombres = nombres;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno){
        if (apellido_materno == null || apellido_materno.isEmpty()) {
            errores.put("apellido_materno","El Apellido Materno no puede estar vacío");
        }
        
        if (apellido_materno.length() > 20) {
            errores.put("apellido_materno","El Apellido Materno no puede exceder los 20 caracteres");
        }
        
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno){
        if (apellido_paterno == null || apellido_paterno.isEmpty()) {
            errores.put("apellido_paterno","El Apellido Paterno no puede estar vacío");
        }
        
        if (apellido_paterno.length() > 20) {
            errores.put("apellido_paterno","El Apellido Paterno no puede exceder los 20 caracteres");
        }
        
        this.apellido_paterno = apellido_paterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws Exception {
        if (dni == null || dni.isEmpty()) {
            errores.put("dni","El campo DNI no puede estar en blanco");
        }
        
        if (!Validator.isDNI(dni)) {
            errores.put("dni","Error en el formato de DNI");
        }
        
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave){
        if (clave == null || clave.isEmpty()) {
            errores.put("clave","El campo Clave no puede estar vacío");
        }
        
        if (clave.length() < 8 || clave.length() > 20) {
            errores.put("claveLen","La longitud de la Clave debe estar entre 8 y 20 caracteres");
        }
        
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol){
        if (( rol == null ) || ( rol.isEmpty() )) {
            errores.put("rol","El campo rol esta vacio");
        }
        this.rol = rol;
    }

    public String getApellidosNombres() {
        return apellidosNombres;
    }

    public void setApellidosNombres(String apellidosNombres) {
        this.apellidosNombres = apellidosNombres;
    }
}
