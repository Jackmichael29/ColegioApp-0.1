/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import Connection.UConnection;
import DataAccessLayer.PagoPensionDAO;
import DataAccessLayer.PagoVariosDAO;
import JavaBean.pagoVarios;
import Utilities.Bitacora;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Shandé HM
 */
public class PagoVariosBO {
    public void insertarPagoVarios(pagoVarios pagoVar) throws Exception{
        try {
            PagoVariosDAO pagoVariosDAO = new PagoVariosDAO();
            pagoVariosDAO.insertarPagoVarios(pagoVar);
        } catch (Exception e) {
            throw e;
        } 
    }
    
    public void actualizarPagoVarios(pagoVarios pagoVar) throws Exception{
        try {
            PagoVariosDAO pagoVariosDAO = new PagoVariosDAO();
            pagoVariosDAO.actualizarPagoVarios(pagoVar);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarPagoVariosPorId(int id) throws Exception{     
        try {
            PagoVariosDAO pagoVariosDAO = new PagoVariosDAO();
            pagoVariosDAO.eliminarPagoVariosPorId(id);
        } catch (Exception e) {
            throw e;
        }        
    }

    public pagoVarios buscarPagoVariosPorAlumnoId(int id) throws Exception{
        try {
            PagoVariosDAO pagoVariosDAO = new PagoVariosDAO();
            return pagoVariosDAO.buscarPagoVariosPorAlumnoId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<pagoVarios> listarPagoVarios() throws Exception{
        try {
            PagoVariosDAO pagoVariosDAO = new PagoVariosDAO();
            return pagoVariosDAO.listarPagoVarios();
        } catch (Exception e) {
            throw e;
        }
    }
}
