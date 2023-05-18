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
    public void insertar(DocenteCurso docentecurso) throws Exception{
        try {
            DocenteCursoDAO docentecursodao = new DocenteCursoDAO();
            docentecursodao.insertar(docentecurso);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizar(DocenteCurso docentecurso) throws Exception{
        try {
            DocenteCursoDAO docentecursodao = new DocenteCursoDAO();
            docentecursodao.actualizar(docentecurso);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(int id) throws Exception{
        try {
            DocenteCursoDAO docentecursodao = new DocenteCursoDAO();
            docentecursodao.eliminar(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<DocenteCurso> listar() throws Exception{
        try {
            DocenteCursoDAO docentecursodao = new DocenteCursoDAO();
            return docentecursodao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<DocenteCurso> buscarCursosPorDocenteId(int id) throws Exception{
        try {
            DocenteCursoDAO docentecursodao = new DocenteCursoDAO();
            return docentecursodao.buscarCursosPorDocenteId(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
