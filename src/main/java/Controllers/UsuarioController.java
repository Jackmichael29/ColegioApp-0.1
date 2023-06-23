/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BusinessLayer.UsuarioBO;
import JavaBean.Usuario;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author xbest
 */
@WebServlet(name = "Usuario", urlPatterns = {"/Usuario"})
public class UsuarioController extends HttpServlet {
    
    static final String PATH_FORM_NEW="/View/Usuario/usuario-form-new.jsp";
    static final String PATH_FORM_EDIT="/View/Usuario/usuario-form-edit.jsp";
    static final String PATH_RESULT="/View/Usuario/usuario-result.jsp";
    static final String PATH_INDEX="/View/Usuario/usuario-index.jsp"; 
    static final String PATH_FORM_CAMBIAR_CLAVE="/View/Usuario/usuario-form-cambiarClave.jsp"; 
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "new":                    
                    showNewForm(request, response);
                    break;
                case "insert":
                    insert(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;   
                case "cambiarClave":
                    cambiarClave(request, response);
                    break;
                case "cambioClave":
                    showChangePasswordForm(request, response);
            }
            } catch (Exception e) {
                System.out.println(e);
                throw new ServletException(e);
            }   
        
    }    
    
    private void index(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
      
        
        String  apeNom=request.getParameter("apellidosNombres");        
        
        UsuarioBO usuarioBO= new UsuarioBO(); 
        ArrayList<Usuario> usuarios=usuarioBO.buscarPorUsuario(apeNom);
        request.setAttribute("usuarios", usuarios);
    
        getServletContext().getRequestDispatcher(PATH_INDEX).forward(request, response);
  
    }
    
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {       
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_FORM_NEW);
        dispatcher.forward(request, response);
    }
    
    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {        
        
       int id = Integer.parseInt(request.getParameter("id"));
        
       UsuarioBO usuarioBO= new UsuarioBO();       
       Usuario usuario=usuarioBO.buscarPorId(id);
       
       if(usuario==null){
        request.setAttribute("mensaje", "Usuario no encontrado");       
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
      
       }else{
        request.setAttribute("usuario", usuario);       
        getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
       }             

    }
    
    
    private void showChangePasswordForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {        
        
       int id = Integer.parseInt(request.getParameter("id"));
        
       UsuarioBO usuarioBO= new UsuarioBO();       
       Usuario usuario=usuarioBO.buscarPorId(id);
       
       if(usuario==null){
        request.setAttribute("mensaje", "Usuario no encontrado");       
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
      
       }else{
        request.setAttribute("usuario", usuario);       
        getServletContext().getRequestDispatcher(PATH_FORM_CAMBIAR_CLAVE).forward(request, response);
       }             

    }
    
    
    private void insert(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        
        Usuario usuario = new Usuario();
        
        usuario.setDni(request.getParameter("dni"));
        usuario.setApellido_paterno(request.getParameter("apellidoPaterno"));
        usuario.setApellido_materno(request.getParameter("apellidoMaterno"));
        usuario.setNombres(request.getParameter("nombres"));
        usuario.setRol(request.getParameter("rol"));
        usuario.setClave(request.getParameter("clave"));
        Map<String,String>errores = usuario.getErrores();
                   
        if(errores.isEmpty()){                
           UsuarioBO usuarioBO= new UsuarioBO();          
           usuarioBO.insertar(usuario);
           request.setAttribute("mensaje", "El registro fué insertado con éxito");  
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("usuario", usuario);
            request.setAttribute("errores", errores);            
         
            getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);
        }
    }
    
    
    private void cambiarClave(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        
        Usuario usuario = new Usuario();
        
        usuario.setClave(request.getParameter("clave"));
        System.out.println("clave controller obtenido: " + request.getParameter("clave"));
        Map<String,String>errores = usuario.getErrores();
                   
        if(errores.isEmpty()){                
           UsuarioBO usuarioBO= new UsuarioBO();          
           usuarioBO.cambiarClave(usuario, "new clave");
           request.setAttribute("mensaje", "La clave se cambio con éxito");  
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("usuario", usuario);
            request.setAttribute("errores", errores);            
         
            getServletContext().getRequestDispatcher(PATH_FORM_CAMBIAR_CLAVE).forward(request, response);
        }
    }
    
    
    private void update(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {      
       
        
        Usuario usuario = new Usuario();
        
        usuario.setUsuario_id(Integer.parseInt(request.getParameter("id")));
        usuario.setDni(request.getParameter("dni"));
        usuario.setApellido_paterno(request.getParameter("apellidoPaterno"));
        usuario.setApellido_materno(request.getParameter("apellidoMaterno"));
        usuario.setNombres(request.getParameter("nombres"));        
        usuario.setRol(request.getParameter("rol"));
        
        Map<String,String>errores= usuario.getErrores();
                   
        if(errores.isEmpty()){                
           UsuarioBO usuarioBO= new UsuarioBO(); 
           usuarioBO.actualizar(usuario);
           request.setAttribute("mensaje", "El registro fué actualizado con éxito"); 
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("usuario", usuario);
            request.setAttribute("errores", errores);            
            
            getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
        }        
    }
    
    
    private void delete(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));        
        
        UsuarioBO usuarioBO= new UsuarioBO(); 
        usuarioBO.eliminar(id);
        request.setAttribute("mensaje", "El registro fué eliminado con éxito"); 
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
