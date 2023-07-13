/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BusinessLayer.AreaBO;
import JavaBean.Area;
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
@WebServlet(name = "AreaController", urlPatterns = {"/Area"})
public class AreaController extends HttpServlet {

    static final String PATH_FORM_NEW="/View/Area/area-form-new.jsp";
    static final String PATH_FORM_EDIT="/View/Area/area-form-edit.jsp";
    static final String PATH_RESULT="/View/Area/area-result.jsp";
    static final String PATH_INDEX="/View/Area/area-index.jsp"; 
    
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
                System.out.println(e);
                throw new ServletException(e);
            }   
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AreaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AreaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    
    
    private void index(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
      
        String  areaNom = request.getParameter("nombreArea");
        System.out.println("lo que obtienes es: ");
        System.out.println(areaNom);
        if(areaNom == null){
            areaNom = "";
        }
        AreaBO areaBO = new AreaBO(); 
        ArrayList<Area> areas = areaBO.buscarPorArea(areaNom);
//        ArrayList<Area> areas = areaBO.buscarPorArea("");
        request.setAttribute("areas", areas);
    
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
        
       AreaBO areaBO= new AreaBO();        
       Area area = areaBO.buscarPorId(id);
       
       if(area==null){
        request.setAttribute("mensaje", "Area no encontrado");       
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
      
       }else{
        request.setAttribute("area", area);       
        getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
       }             

    }
    
    
    private void insert(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        
        Area area = new Area();

        area.setArea_nombre(request.getParameter("areaNombre"));
                 
        Map<String,String>errores = area.getErrores();
                   
        if(errores.isEmpty()){                
            try {
                AreaBO areaBO = new AreaBO();          
                areaBO.insertar(area);
                request.setAttribute("mensaje", "El registro fué insertado con éxito");  
            } catch (Exception e) {
                request.setAttribute("mensaje", e.getMessage());  
            }
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("area", area);
            request.setAttribute("errores", errores);            
         
            getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);
        }
    }
    
    
    private void update(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {      
       
        
        Area area = new Area();
        
        area.setArea_id(Integer.parseInt(request.getParameter("id")));
        area.setArea_nombre(request.getParameter("areaNombre"));
        
        
        Map<String,String>errores = area.getErrores();
                   
        if(errores.isEmpty()){                
            try {
                AreaBO areaBO = new AreaBO(); 
                areaBO.actualizar(area);
                request.setAttribute("mensaje", "El registro fué actualizado con éxito"); 
            } catch (Exception e) {
                request.setAttribute("mensaje", e.getMessage()); 
            }
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("area", area);
            request.setAttribute("errores", errores);            
            
            getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
        }        
    }
    
    
    private void delete(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));        
        
        AreaBO areaBO = new AreaBO();
        
        String mensaje = "El registro fué eliminado con éxito";
        
        try {
            areaBO.eliminar(id);
        } catch (Exception e) {
            if(e.getMessage().contains("java.sql.SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails"))
                mensaje = "No se puede borrar el registro debido a una violación de clave foránea."; 
            
            else
                mensaje = "Hubo un error inesperado al eliminar el registro";
        }
        
        request.setAttribute("mensaje", mensaje); 
        
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
