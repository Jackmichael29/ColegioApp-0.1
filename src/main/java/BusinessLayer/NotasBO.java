/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import Connection.UConnection;
import DataAccessLayer.NotasDAO;
import DataAccessLayer.UsuarioDAO;
import JavaBean.Notas;
import Utilities.Bitacora;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Shandé HM
 */
public class NotasBO {
    
    public void insertar(Notas notas) throws Exception{        
        
        try {
            NotasDAO notasDAO = new NotasDAO();
            notasDAO.insertar(notas);
            System.out.println("llamado1");
        } catch (Exception e) {
            throw e;
        }     
    }
    
    public void eliminar(int id) throws Exception{    
        
        try {
            NotasDAO notasDAO = new NotasDAO();
            notasDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    public void actualizar(Notas notas) throws Exception{        
        
        try {
            NotasDAO notasDAO = new NotasDAO();
            notasDAO.actualizar(notas);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    public Notas buscarPorHistorialNotasId(int cadena) throws Exception{
     
        try {
            NotasDAO notasDAO = new NotasDAO();
            return notasDAO.buscarPorHistorialNotasId(cadena);
        } catch (Exception e) {
            throw e;
        }     
     }
    
    public ArrayList<Notas> notasListar() throws Exception{
     
        try {
            NotasDAO notasDAO = new NotasDAO();
            return notasDAO.notasListar();
        } catch (Exception e) {
            throw e;
        }     
     }
    
    public double determinarPromedio(int cadena) throws Exception{
        
        try {
            NotasDAO notasDAO = new NotasDAO();
            return notasDAO.determinarPromedio(cadena);
        } catch (Exception e) {
            throw e;
        }     
    }
}
