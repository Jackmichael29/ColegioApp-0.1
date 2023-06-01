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
public class Area {
    
    private int area_id;
    private String area_nombre;
    
    private Map<String,String> errores = new HashMap<>();
    
    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    public Area() {
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getArea_nombre() {
        return area_nombre;
    }

    public void setArea_nombre(String area_nombre){
        if( (area_nombre==null) || (area_nombre.isEmpty()) ){
            errores.put("area_nombre","El campo Nombre no puede estar vacio");
        }
        
        this.area_nombre = area_nombre;
    }
    
    
}
