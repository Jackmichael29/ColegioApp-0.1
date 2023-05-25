/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import JavaBean.AsistenciaDocente;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class AsistenciaDocenteBO {
    public void insertar(AsistenciaDocente asistenciadocente) throws Exception{
        try {
            AsistenciaDocenteBO asistenciadocenteDAO = new AsistenciaDocenteBO();
            asistenciadocenteDAO.insertar(asistenciadocente);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizar(AsistenciaDocente asistenciadocente) throws Exception{
        try{
            AsistenciaDocenteBO asistenciadocenteDAO = new AsistenciaDocenteBO();
            asistenciadocenteDAO.actualizar(asistenciadocente);
        }catch(Exception e){
            throw e;
        }
        
    }
    
    public void eliminar(int i) throws Exception{
        try {
            AsistenciaDocenteBO asistenciadocenteDAO = new AsistenciaDocenteBO();
            asistenciadocenteDAO.eliminar(i);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public AsistenciaDocente buscarAsistenciaDocentePorDocenteId(int id) throws Exception{
        try {
            AsistenciaDocenteBO asistenciadocenteDAO = new AsistenciaDocenteBO();
            return asistenciadocenteDAO.buscarAsistenciaDocentePorDocenteId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<AsistenciaDocente> asistenciaDocenteListar() throws Exception{
        try {
            AsistenciaDocenteBO asistenciadocenteDAO = new AsistenciaDocenteBO();
            return asistenciadocenteDAO.asistenciaDocenteListar();
        } catch (Exception e) {
            throw e;
        }
    }
}
