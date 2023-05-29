/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLayer;

import DataAccessLayer.UsuarioDAO;
import JavaBean.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author black
 */
public class UsuarioBO {
    
    public void loguin(Usuario usuario) throws Exception{
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.loguin(usuario);
        } catch (Exception e) {
            throw e;
        }
        
     }   
    
    public void insertar(Usuario usuario) throws Exception{        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.insertar(usuario);
        } catch (Exception e) {
            throw e;
        }
     }    
    //-------------------------------------------------------------------------------------
    public void actualizar(Usuario usuario) throws Exception{        
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.actualizar(usuario);
        } catch (Exception e) {
            throw e;
        }    
    }
    
    
     public void eliminar(int id) throws Exception{    
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.eliminar(id);
        } catch (Exception e) {
            throw e;
        }        
    }
    
   
     
     public ArrayList<Usuario> buscarPorUsuario(String cadena) throws Exception{
     
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            return usuarioDAO.buscarPorUsuario(cadena);
        } catch (Exception e) {
            throw e;
        }     
     }
     
     public Usuario buscarPorDNI(String dni) throws Exception{     
        
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            return usuarioDAO.buscarPorDNI(dni);
        } catch (Exception e) {
            throw e;
        }     
     }     
         
      public Usuario buscarPorId(int id) throws Exception{        
       
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
           return usuarioDAO.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }     
     }

      public void cambiarClave(Usuario usuario) throws Exception{ 
          
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.cambiarClave(usuario);
        } catch (Exception e) {
            throw e;
        }
     }
}