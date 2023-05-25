/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.MatriculaDAO;
import JavaBean.Matricula;
import java.util.ArrayList;

/**
 *
 * @author LAB-USR-HUAN-A0305
 */
public class MatriculaBO {
    
    public void insertarMatricula(Matricula matricula) throws Exception{
        try {
            MatriculaDAO matDAO = new MatriculaDAO();
            matDAO.insertarMatricula(matricula);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizarMatricula(Matricula matricula) throws Exception{
        try {
            MatriculaDAO matDAO = new MatriculaDAO();
            matDAO.actualizarMatricula(matricula);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarMatricula(int id) throws Exception{     
        try {
            MatriculaDAO matDAO = new MatriculaDAO();
            matDAO.eliminarMatricula(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Matricula buscarMatriculaPorId(int id) throws Exception{
        try {
            MatriculaDAO matDAO = new MatriculaDAO();
            return matDAO.buscarMatriculaPorId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Matricula> ListarMatriculas() throws Exception{
        try {
            MatriculaDAO matDAO = new MatriculaDAO();
            return matDAO.ListarMatriculas();
        } catch (Exception e) {
            throw e;
        }
    }


}
