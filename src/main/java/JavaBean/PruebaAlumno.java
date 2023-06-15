/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaBean;

import BusinessLayer.AlumnoBO;
import Utilities.Encriptador;
import java.sql.Date;

/**
 *
 * @author black
 */
public class PruebaAlumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Alumno alumno = new Alumno();
//        AlumnoBO alumBO = new AlumnoBO();
//        
//        try {
//            alumno.setAlumno_id(1);
//            alumno.setApellido_materno("A");
//            alumno.setApellido_paterno("AA");
//            alumno.setNombres("Jhon Mark");
//            alumno.setDni("12312312");
//            alumno.setFecha_nacimiento(Date.valueOf("1997-03-10").toLocalDate());
//            alumno.setCorreo_electrico("jhon@adios.com");
//            
//            alumBO.insertar(alumno);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        Encriptador en = new Encriptador();
        String t = en.Encriptar("holamundo");
        System.out.println(t);
    }    
}
