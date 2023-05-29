/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import Connection.UConnection;
import DataAccessLayer.PagoMatriculaDAO;
import DataAccessLayer.PagoVariosDAO;
import JavaBean.pagoMatricula;
import Utilities.Bitacora;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Shandé HM
 */
public class PagoMatriculaBO {
    public void insertarPagoMatricula(pagoMatricula pagoMat) throws Exception{
        try {
            PagoMatriculaDAO pagoMatriculaDAO = new PagoMatriculaDAO();
            pagoMatriculaDAO.insertarPagoMatricula(pagoMat);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizarPagoMatricula(pagoMatricula pagoMat) throws Exception{
        try {
            PagoMatriculaDAO pagoMatriculaDAO = new PagoMatriculaDAO();
            pagoMatriculaDAO.actualizarPagoMatricula(pagoMat);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarPagoMatriculaPorId(int id) throws Exception{     
        try {
            PagoMatriculaDAO pagoMatriculaDAO = new PagoMatriculaDAO();
            pagoMatriculaDAO.eliminarPagoMatriculaPorId(id);
        } catch (Exception e) {
            throw e;
        }        
    }

    public pagoMatricula buscarPagoMatriculaPorAlumnoId(int id) throws Exception{
        try {
            PagoMatriculaDAO pagoMatriculaDAO = new PagoMatriculaDAO();
            return pagoMatriculaDAO.buscarPagoMatriculaPorAlumnoId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public ArrayList<pagoMatricula> listarPagoMatricula() throws Exception{
        try {
            PagoMatriculaDAO pagoMatriculaDAO = new PagoMatriculaDAO();
            return pagoMatriculaDAO.listarPagoMatricula();
        } catch (Exception e) {
            throw e;
        }
    }
}
