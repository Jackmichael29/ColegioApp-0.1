/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BusinessLayer.AlumnoBO;
import JavaBean.Alumno;
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
@WebServlet(name = "AlumnoController", urlPatterns = {"/Alumno"})
public class AlumnoController extends HttpServlet {

    static final String PATH_FORM_NEW="/View/Alumno/alumno-form-new.jsp";
    static final String PATH_FORM_EDIT="/View/Alumno/alumno-form-edit.jsp";
    static final String PATH_RESULT="/View/Alumno/alumno-result.jsp";
    static final String PATH_INDEX="/View/Alumno/alumno-index.jsp"; 
    
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
            out.println("<title>Servlet AlumnoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlumnoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    
    
    private void index(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
      
        
        String  apeNom=request.getParameter("apellidosNombres");        
        
        AlumnoBO alumnoBO= new AlumnoBO(); 
        ArrayList<Alumno> alumnos=alumnoBO.buscarPorAlumno(apeNom);
        request.setAttribute("alumnos", alumnos);
    
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
        
       AlumnoBO alumnoBO= new AlumnoBO();        
       Alumno alumno=alumnoBO.buscarPorId(id);
       
       if(alumno==null){
        request.setAttribute("mensaje", "Alumno no encontrado");       
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
      
       }else{
        request.setAttribute("alumno", alumno);       
        getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
       }             

    }
    
    
    private void insert(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        
        Alumno alumno = new Alumno();
        
        alumno.setDni(request.getParameter("dni"));
        alumno.setApellido_paterno(request.getParameter("apellidoPaterno"));
        alumno.setApellido_materno(request.getParameter("apellidoMaterno"));
        alumno.setNombres(request.getParameter("nombres"));
        
        try {
            alumno.setFecha_nacimiento(LocalDate.parse(request.getParameter("fechaNacimiento"),DateTimeFormatter.ofPattern("yyyy-MM-dd")) );
        } catch (DateTimeParseException e) {
            alumno.setFecha_nacimiento(null);
        }        
        
        alumno.setCorreo_electrico(request.getParameter("correoElectronico"));
                 
        Map<String,String>errores = alumno.getErrores();
                   
        if(errores.isEmpty()){                
           AlumnoBO alumnoBO= new AlumnoBO();          
           alumnoBO.insertar(alumno);
           request.setAttribute("mensaje", "El registro fué insertado con éxito");  
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("alumno", alumno);
            request.setAttribute("errores", errores);            
         
            getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);
        }
    }
    
    
    private void update(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {      
       
        
        Alumno alumno = new Alumno();
        
        alumno.setAlumno_id(Integer.parseInt(request.getParameter("id")));
        alumno.setDni(request.getParameter("dni"));
        alumno.setApellido_paterno(request.getParameter("apellidoPaterno"));
        alumno.setApellido_materno(request.getParameter("apellidoMaterno"));
        alumno.setNombres(request.getParameter("nombres"));        
        
        try {
            alumno.setFecha_nacimiento(LocalDate.parse(request.getParameter("fechaNacimiento"),DateTimeFormatter.ofPattern("yyyy-MM-dd")) );
        } catch (DateTimeParseException e) {
            alumno.setFecha_nacimiento(null);
        }        
        
        alumno.setCorreo_electrico(request.getParameter("correoElectronico"));
        
        
        Map<String,String>errores= alumno.getErrores();
                   
        if(errores.isEmpty()){                
           AlumnoBO alumnoBO= new AlumnoBO(); 
           alumnoBO.actualizar(alumno);
           request.setAttribute("mensaje", "El registro fué actualizado con éxito"); 
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("alumno", alumno);
            request.setAttribute("errores", errores);            
            
            getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
        }        
    }
    
    
    private void delete(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));        
        
        AlumnoBO alumnoBO= new AlumnoBO(); 
            alumnoBO.eliminar(id);
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
