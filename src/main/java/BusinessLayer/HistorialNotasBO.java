/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.HistorialNotasDAO;
import java.util.ArrayList;
import JavaBean.HistorialNotas;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class HistorialNotasBO {
    public void insertar(HistorialNotas hnotas) throws Exception{        
        try {
            HistorialNotasDAO hisDAO = new HistorialNotasDAO();
            hisDAO.insertar(hnotas);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(int id) throws Exception{    
        try {
            HistorialNotasDAO hisDAO = new HistorialNotasDAO();
            hisDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizar(HistorialNotas hnotas) throws Exception{        
        try {
            HistorialNotasDAO hisDAO = new HistorialNotasDAO();
            hisDAO.actualizar(hnotas);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public HistorialNotas buscarPorAlumnoId(int cadena) throws Exception{
        try {
            HistorialNotasDAO hisDAO = new HistorialNotasDAO();
            return hisDAO.buscarPorAlumnoId(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public HistorialNotas buscarPorCursoId(int cadena) throws Exception{
        try {
            HistorialNotasDAO hisDAO = new HistorialNotasDAO();
            return hisDAO.buscarPorCursoId(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<HistorialNotas> historialNotasListar() throws Exception{
        try {
            HistorialNotasDAO hisDAO = new HistorialNotasDAO();
            return hisDAO.historialNotasListar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<HistorialNotas> buscarPorCurso(String nombre, String nivel, String grado) throws Exception{
        try {
            HistorialNotasDAO hisDAO = new HistorialNotasDAO();
            return hisDAO.buscarPorCurso(nombre, nivel, grado);
        } catch (Exception e) {
            throw e;
        }
    }
}
