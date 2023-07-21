/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BusinessLayer.DocenteBO;
import Connection.UConnection;
import JavaBean.Docente;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author xbest
 */
@WebServlet(name = "DocenteController", urlPatterns = {"/Docente"})
public class DocenteController extends HttpServlet {

    static final String PATH_FORM_NEW="/View/Docente/docente-form-new.jsp";
    static final String PATH_FORM_EDIT="/View/Docente/docente-form-edit.jsp";
    static final String PATH_RESULT="/View/Docente/docente-result.jsp";
    static final String PATH_INDEX="/View/Docente/docente-index.jsp"; 
    
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
                case "reportes":
                    reporteDocentes(request, response);
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
            out.println("<title>Servlet DocenteController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DocenteController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }    
    
    private void index(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
      
        
        String  apeNom = request.getParameter("apellidosNombres");        
        
        DocenteBO docenteBO = new DocenteBO(); 
        ArrayList<Docente> docentes = docenteBO.buscarPorDocente(apeNom);
        request.setAttribute("docentes", docentes);
    
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
        
       DocenteBO docenteBO= new DocenteBO();        
       Docente docente = docenteBO.buscarPorId(id);
       
       if(docente==null){
        request.setAttribute("mensaje", "Docente no encontrado");       
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
      
       }else{
        request.setAttribute("docente", docente);       
        getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
       }             

    }
    
    
    private void insert(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        
        Docente docente = new Docente();
        
        docente.setDni(request.getParameter("dni"));
        docente.setApellido_paterno(request.getParameter("apellidoPaterno"));
        docente.setApellido_materno(request.getParameter("apellidoMaterno"));
        docente.setNombres(request.getParameter("nombres"));
        docente.setContacto(request.getParameter("contacto"));
                 
        Map<String,String>errores = docente.getErrores();
                   
        if(errores.isEmpty()){                
           DocenteBO docenteBO= new DocenteBO();          
           docenteBO.insertar(docente);
           request.setAttribute("mensaje", "El registro fué insertado con éxito");  
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("docente", docente);
            request.setAttribute("errores", errores);            
         
            getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);
        }
    }
    
    
    private void update(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {      
       
        
        Docente docente = new Docente();
        
        docente.setDocente_id(Integer.parseInt(request.getParameter("id")));
        docente.setDni(request.getParameter("dni"));
        docente.setApellido_paterno(request.getParameter("apellidoPaterno"));
        docente.setApellido_materno(request.getParameter("apellidoMaterno"));
        docente.setNombres(request.getParameter("nombres"));
        docente.setContacto(request.getParameter("contacto"));
        
        
        Map<String,String>errores = docente.getErrores();
                   
        if(errores.isEmpty()){                
           DocenteBO docenteBO= new DocenteBO(); 
           docenteBO.actualizar(docente);
           request.setAttribute("mensaje", "El registro fué actualizado con éxito"); 
           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        }else{
            request.setAttribute("docente", docente);
            request.setAttribute("errores", errores);            
            
            getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
        }        
    }
    
    
    private void delete(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));        
        
        DocenteBO docenteBO= new DocenteBO(); 
        docenteBO.eliminar(id);
        request.setAttribute("mensaje", "El registro fué eliminado con éxito"); 
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);        

    }
    
    private void reporteDocentes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JRException, Exception {

        String url = getServletContext().getRealPath("/View/Resources/img/logoHD.png");

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("url", url);
        

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"ReporteDocentes.pdf\";");

        String pathReporte = getServletContext().getRealPath("/View/Reportes/ReporteDocente.jasper");
        JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(pathReporte);

        ServletOutputStream out = response.getOutputStream();

        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, params, UConnection.getConnection());
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

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
