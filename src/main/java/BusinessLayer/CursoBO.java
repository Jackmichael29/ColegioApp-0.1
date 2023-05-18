/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.CursoDAO;
import JavaBean.Curso;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class CursoBO {
    public void insertar(Curso curso) throws Exception{
        try {
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.insertar(curso);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizar(Curso curso) throws Exception{
        try {
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.modificar(curso);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(int id) throws Exception{
        try {
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Curso> buscarPorCurso(String cadena) throws Exception{
        try {
            CursoDAO cursoDAO = new CursoDAO();
            return cursoDAO.buscarPorCurso(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Curso buscarPorCursoId(int id) throws Exception{
        try {
            CursoDAO cursoDAO = new CursoDAO();
            return cursoDAO.buscarPorCursoId(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
