/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.DocenteDAO;
import JavaBean.Docente;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class DocenteBO {
    public ArrayList<Docente> buscarPorDocente(String cadena) throws Exception{
        try {
            DocenteDAO docDAO = new DocenteDAO();
            return docDAO.buscarPorDocente(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Docente buscarPorDNI(String cadena) throws Exception{
        try {
            DocenteDAO docDAO = new DocenteDAO();
            return docDAO.buscarPorDNI(cadena);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Docente buscarPorId(int id) throws Exception{
        try {
            DocenteDAO docDAO = new DocenteDAO();
            return docDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizar(Docente docente) throws Exception{
        try {
            DocenteDAO docDAO = new DocenteDAO();
            docDAO.actualizar(docente);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(int idx) throws Exception{
        try {
            DocenteDAO docDAO = new DocenteDAO();
            docDAO.eliminar(idx);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Docente> listar() throws Exception{
        try {
            DocenteDAO docDAO = new DocenteDAO();
            return docDAO.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void insertar(Docente docente) throws Exception{
        try {
            DocenteDAO docDAO = new DocenteDAO();
            docDAO.insertar(docente);
        } catch (Exception e) {
            throw e;
        }
    }
}
