/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BusinessLayer.ApoderadoBO;
import JavaBean.Apoderado;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author xbest
 */
@WebServlet(name = "ApoderadoController", urlPatterns = {"/Apoderado"})
public class ApoderadoController extends HttpServlet {

    static final String PATH_FORM_NEW="/View/Apoderado/apoderado-form-new.jsp";
    static final String PATH_FORM_EDIT="/View/Apoderado/apoderado-form-edit.jsp";
    static final String PATH_RESULT="/View/Apoderado/apoderado-result.jsp";
    static final String PATH_INDEX="/View/Apoderado/apoderado-index.jsp"; 
    
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
            }
            } catch (Exception e) {
                throw new ServletException(e);
            }   
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApoderadoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ApoderadoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    
    
    private void index(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
      
        
        String  apeNom = request.getParameter("apellidosNombres");        
        
        ApoderadoBO apoderadoBO = new ApoderadoBO(); 
        ArrayList<Apoderado> apoderados = apoderadoBO.buscarApoderadoPorNombre(apeNom);
        request.setAttribute("apoderados", apoderados);
    
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
        
       ApoderadoBO apoderadoBO= new ApoderadoBO();        
       Apoderado apoderado = apoderadoBO.buscarApoderadoPorId(id);
       
       if(apoderado==null){
        request.setAttribute("mensaje", "Apoderado no encontrado");       
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
      
       }else{
        request.setAttribute("apoderado", apoderado);       
        getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
       }             

    }
    
    
    private void insert(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        
        Apoderado apoderado = new Apoderado();
        
        apoderado.setDni(request.getParameter("dni"));
        apoderado.setApellido_paterno(request.getParameter("apellidoPaterno"));
        apoderado.setApellido_materno(request.getParameter("apellidoMaterno"));
        apoderado.setNombres(request.getParameter("nombres"));
        apoderado.setContacto(request.getParameter("contacto"));
        
        Map<String,String>errores = apoderado.getErrores();
                   
        if(errores.isEmpty()){                
           ApoderadoBO apoderadoBO= new ApoderadoBO();          
           apoderadoBO.insertarApoderado(apoderado);
           request.setAttribute("mensaje", "El registro fué insertado con éxito");  
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("apoderado", apoderado);
            request.setAttribute("errores", errores);            
         
            getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);
        }
    }
    
    
    private void update(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {      
       
        
        Apoderado apoderado = new Apoderado();
        
        apoderado.setApoderado_id(Integer.parseInt(request.getParameter("id")));
        apoderado.setDni(request.getParameter("dni"));
        apoderado.setApellido_paterno(request.getParameter("apellidoPaterno"));
        apoderado.setApellido_materno(request.getParameter("apellidoMaterno"));
        apoderado.setNombres(request.getParameter("nombres"));
        apoderado.setContacto(request.getParameter("contacto"));
        
        
        Map<String,String>errores = apoderado.getErrores();
                   
        if(errores.isEmpty()){                
           ApoderadoBO apoderadoBO= new ApoderadoBO(); 
           apoderadoBO.actualizarApoderado(apoderado);
           request.setAttribute("mensaje", "El registro fué actualizado con éxito"); 
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("apoderado", apoderado);
            request.setAttribute("errores", errores);            
            
            getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
        }        
    }
    
    
    private void delete(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));        
        
        ApoderadoBO apoderadoBO= new ApoderadoBO(); 
        apoderadoBO.eliminarApoderado(id);
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
        return "Servlet Alumno - shows interactivity with class Alumno";
    }// </editor-fold>

}
