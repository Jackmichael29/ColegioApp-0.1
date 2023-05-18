/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.AsistenciaAlumnoDAO;
import JavaBean.AsistenciaAlumno;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class AsistenciaAlumnoBO {
    public void insertar(AsistenciaAlumno asistenciaalumno) throws Exception{
        try {
            AsistenciaAlumnoDAO asistenciaalumnoDAO = new AsistenciaAlumnoDAO();
            asistenciaalumnoDAO.insertarAsistenciaAlumno(asistenciaalumno);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizar(AsistenciaAlumno asistenciaalumno) throws Exception{
        try{
            AsistenciaAlumnoDAO asistenciaalumnoDAO = new AsistenciaAlumnoDAO();
            asistenciaalumnoDAO.actualizarAsistenciaAlumno(asistenciaalumno);
        }catch (Exception e) {
            throw e;
        }
        
    }
    
    public void eliminar(int i) throws Exception{
        try {
            AsistenciaAlumnoDAO asistenciaalumnoDAO = new AsistenciaAlumnoDAO();
            asistenciaalumnoDAO.eliminarAsistenciaAlumno(i);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public ArrayList<AsistenciaAlumno> buscarAsistenciaAlumnoPorAlumnoId(int id) throws Exception{
        try {
            AsistenciaAlumnoDAO asistenciaalumnoDAO = new AsistenciaAlumnoDAO();
            return asistenciaalumnoDAO.buscarAsistenciaAlumnoPorAlumnoId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<AsistenciaAlumno> listarAsistenciaAlumno() throws Exception{
        try {
            AsistenciaAlumnoDAO asistenciaalumnoDAO = new AsistenciaAlumnoDAO();
            return asistenciaalumnoDAO.listarAsistenciaAlumno();
        } catch (Exception e) {
            throw e;
        }
    }
}
