/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BusinessLayer.CursoBO;
import JavaBean.Curso;
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
@WebServlet(name = "CursoController", urlPatterns = {"/Curso"})
public class CursoController extends HttpServlet {

    static final String PATH_FORM_NEW="/View/Curso/curso-form-new.jsp";
    static final String PATH_FORM_EDIT="/View/Curso/curso-form-edit.jsp";
    static final String PATH_RESULT="/View/Curso/curso-result.jsp";
    static final String PATH_INDEX="/View/Curso/curso-index.jsp"; 
    
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
            out.println("<title>Servlet CursoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CursoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    
    
    private void index(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
      
        
        String  nombre = request.getParameter("nombre");        
        
        CursoBO cursoBO = new CursoBO(); 
        ArrayList<Curso> cursos = cursoBO.buscarPorCurso(nombre);
        request.setAttribute("cursos", cursos);
    
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
        
       CursoBO cursoBO= new CursoBO();        
       Curso curso = cursoBO.buscarPorCursoId(id);
       
       if(curso==null){
        request.setAttribute("mensaje", "Curso no encontrado");       
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
      
       }else{
        request.setAttribute("curso", curso);       
        getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
       }             

    }
    
    
    private void insert(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        
        Curso curso = new Curso();
        
        curso.setNombre(request.getParameter("nombre"));
        
        if(!(request.getParameter("grado").charAt(0) == '0'))
            curso.setGrado(request.getParameter("grado").charAt(0));
        else
            curso.setGrado(' ');
            
        if(!(request.getParameter("nivel").charAt(0) == '0'))
            curso.setNivel(request.getParameter("nivel").charAt(0));
        else
            curso.setNivel(' ');
        
        Map<String,String>errores = curso.getErrores();
        
        try {
            curso.setArea_id(Integer.parseInt(request.getParameter("areaId")));
        } catch (Exception e) {
            if(e.getMessage().contains("For input string:"))
                errores.put("area_id", "El campo Area id no debe contener letras.");
            else
                errores.put("area_id", e.getMessage()+"a");
        }
                   
        if(errores.isEmpty()){                
           CursoBO cursoBO= new CursoBO();          
            try {
                cursoBO.insertar(curso);
                request.setAttribute("mensaje", "El registro fué insertado con éxito");
            } catch (Exception e) {
                if(e.getMessage().contains("El id del area no es válido")){
                    errores.put("area_id", e.getMessage());
                    
                    request.setAttribute("curso", curso);
                    request.setAttribute("errores", errores);            
         
                    getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);
                }
                request.setAttribute("mensaje", "No se pudo insertar el registro"); 
            }
            finally{
                getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
            }
        }else{
            request.setAttribute("curso", curso);
            request.setAttribute("errores", errores);            
         
            getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);
        }
    }
    
    
    private void update(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {      
       
        
        Curso curso = new Curso();
        
        curso.setCurso_id( Integer.parseInt( request.getParameter("id") ) );
        curso.setNombre(request.getParameter("nombre"));
        
        if(!(request.getParameter("grado").charAt(0) == '0'))
            curso.setGrado(request.getParameter("grado").charAt(0));
        else
            curso.setGrado(' ');
            
        if(!(request.getParameter("nivel").charAt(0) == '0'))
            curso.setNivel(request.getParameter("nivel").charAt(0));
        else
            curso.setNivel(' ');
        
        Map<String,String>errores = curso.getErrores();
        
        try {
            curso.setArea_id(Integer.parseInt(request.getParameter("areaId")));
        } catch (Exception e) {
            if(e.getMessage().contains("For input string:"))
                errores.put("area_id", "El campo Area id no debe contener letras.");
            else
                errores.put("area_id", e.getMessage()+"a");
        }
                   
        if(errores.isEmpty()){
            CursoBO cursoBO= new CursoBO();
            try {
                cursoBO.actualizar(curso);
                request.setAttribute("mensaje", "El registro fué actualizado con éxito");
            } catch (Exception e) {
                if(e.getMessage().contains("El id del area no es válido")){
                    errores.put("area_id", e.getMessage());
                    
                    request.setAttribute("curso", curso);
                    request.setAttribute("errores", errores);            
         
                    getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);
                }
                request.setAttribute("mensaje", "El registro no fué actualizado"); 
            }
            finally{
                getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
            }
        }else{
            request.setAttribute("curso", curso);
            request.setAttribute("errores", errores);            
            
            getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
        }        
    }
    
    
    private void delete(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));        
        
        CursoBO cursoBO= new CursoBO();  
        cursoBO.eliminar(id);
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
