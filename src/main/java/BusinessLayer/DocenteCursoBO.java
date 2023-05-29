/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.DocenteCursoDAO;
import JavaBean.DocenteCurso;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class DocenteCursoBO {
    public ArrayList<DocenteCurso> buscarCursoAsignadoPorDNIDocente(String dni) throws Exception{
        try {
            DocenteCursoDAO docuDAO = new DocenteCursoDAO();
            return docuDAO.buscarCursoAsignadoPorDNIDocente(dni);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void insertar(DocenteCurso docenteCurso) throws Exception{
        try {
            DocenteCursoDAO docuDAO = new DocenteCursoDAO();
            docuDAO.insertar(docenteCurso);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizar(DocenteCurso docenteCurso) throws Exception{        
        try {
            DocenteCursoDAO docuDAO = new DocenteCursoDAO();
            docuDAO.actualizar(docenteCurso);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(int id) throws Exception{    
        try {
            DocenteCursoDAO docuDAO = new DocenteCursoDAO();
            docuDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<DocenteCurso> listar() throws Exception{
        try {
            DocenteCursoDAO docuDAO = new DocenteCursoDAO();
            return docuDAO.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<DocenteCurso> buscarCursosPorDocenteId(int id) throws Exception{
        try {
            DocenteCursoDAO docuDAO = new DocenteCursoDAO();
            return docuDAO.buscarCursosPorDocenteId(id);
        } catch (Exception e) {
            throw e;
        }  
    }
    
    
}
