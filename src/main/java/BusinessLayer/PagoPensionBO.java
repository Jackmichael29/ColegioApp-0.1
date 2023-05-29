/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import Connection.UConnection;
import DataAccessLayer.NotasDAO;
import DataAccessLayer.PagoPensionDAO;
import JavaBean.pagoPensiones;
import Utilities.Bitacora;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Shandé HM
 */
public class PagoPensionBO {
    public void insertarPagoPension(pagoPensiones pagoPe) throws Exception{
        try {
            PagoPensionDAO pagoPensionDAO = new PagoPensionDAO();
            pagoPensionDAO.insertarPagoPension(pagoPe);
        } catch (Exception e) {
            throw e;
        }  
    }
    
    public void actualizarPagoPension(pagoPensiones pagoPe) throws Exception{
        try {
            PagoPensionDAO pagoPensionDAO = new PagoPensionDAO();
            pagoPensionDAO.actualizarPagoPension(pagoPe);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarPagoPensionPorId(int id) throws Exception{     
        try {
            PagoPensionDAO pagoPensionDAO = new PagoPensionDAO();
            pagoPensionDAO.eliminarPagoPensionPorId(id);
        } catch (Exception e) {
            throw e;
        }        
    }

    public pagoPensiones buscarPagoPensionPorAlumnoId(int id) throws Exception{
        try {
            PagoPensionDAO pagoPensionDAO = new PagoPensionDAO();
            return pagoPensionDAO.buscarPagoPensionPorAlumnoId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<pagoPensiones> listarPagoPension() throws Exception{
        try {
            PagoPensionDAO pagoPensionDAO = new PagoPensionDAO();
            return pagoPensionDAO.listarPagoPension();
        } catch (Exception e) {
            throw e;
        }
    }
}
