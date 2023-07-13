/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BusinessLayer.AlumnoBO;
import BusinessLayer.CursoBO;
import BusinessLayer.DocenteCursoBO;
import BusinessLayer.HistorialNotasBO;
import BusinessLayer.MatriculaBO;
import BusinessLayer.NotasBO;
import Connection.UConnection;
import DataAccessLayer.NotasDAO;
import JavaBean.Alumno;
import JavaBean.Curso;
import JavaBean.DocenteCurso;
import JavaBean.HistorialNotas;
import JavaBean.Matricula;
import JavaBean.MatriculaCurso;
import JavaBean.Notas;
import com.google.gson.Gson;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
 * @author walter
 */
@WebServlet("/Nota")
public class NotaController extends HttpServlet {
 

    //static final String PATH_FORM_NEW="/View/Matricula/matricula-form-new.jsp";
    static final String PATH_FORM_EDIT="/View/Notas/nota-form-edit.jsp";
    static final String PATH_RESULT="/View/Notas/nota-result.jsp";
    static final String PATH_FORM_REPORT="/View/Reportes/ReporteNotasPorAula.jsp"; 
    static final String PATH_LIST_COURSE="/View/Notas/nota-lista-cursos-asignados.jsp";
    //static final String PATH_SEARCH_ALU_BY_ID="/View/Matricula/matricula-buscar-alumno-id.jsp";
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
            processRequest(request, response);        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "reportNotasPorAula":                    
                    reportNotasPorAula(request, response);
                    break;
                case "showReportForm":
                    showReportForm(request, response);
                    break;
                case "editNota":
                    editNota(request, response);
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

    
    
    private void index(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        HttpSession session=request.getSession(); 
        String  dni=String.valueOf(session.getAttribute("usuario"));
        String cursoname = request.getParameter("nombreCurso");
        String nivel = request.getParameter("nivel");
        String grado = request.getParameter("grado");
        HistorialNotasBO hnotasBO = new HistorialNotasBO();
        if(nivel==null){
            System.out.println("nivel");
            nivel="";
        }
        if(grado==null){
            System.out.println("grado");
            grado="";
        }
        if(cursoname==null){
            System.out.println("cursoname");
            cursoname="";
        }
        
        ArrayList<HistorialNotas> hnotas = hnotasBO.buscarPorCurso(cursoname, nivel, grado);
        
        request.setAttribute("notas", hnotas);
        
        getServletContext().getRequestDispatcher(PATH_LIST_COURSE).forward(request, response);
    }
    
    private void editNota(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        String val = request.getParameter("notaId");
        
        if(val==null){
            val="0";
        }
        int idHistorial = Integer.parseInt(val);
        NotasBO ndao = new NotasBO();
        Notas notas = ndao.buscarPorHistorialNotasId(idHistorial);
        HistorialNotasBO hnotasbo = new HistorialNotasBO();
        HistorialNotas hnotita = hnotasbo.buscarPorId(idHistorial);
        System.out.println("nombrecitoyape : "+ hnotita.getAlumno().getApellidosNombres());
        System.out.println("nombrecito : "+ hnotita.getAlumno().getNombres());
        System.out.println("gradito : "+ hnotita.getCurso().getGrado());
        System.out.println("nivel : "+ hnotita.getCurso().getNivel());
        request.setAttribute("notas", notas);
        request.setAttribute("hnotita", hnotita);
        getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);  
 
        

    }
    
    private void reportNotasPorAula(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JRException, Exception {

        String grado = request.getParameter("grado");
        String nivel = request.getParameter("nivel");
        String turno = request.getParameter("turno");

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("grado", grado);
        params.put("nivel", nivel);
        params.put("turno", turno);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"ReporteNotasPorAula.pdf\";");

        String pathReporte = getServletContext().getRealPath("/View/Reportes/ReporteNotasPorAula.jasper");
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
    
    private void showReportForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
                 
       
        String grado=request.getParameter("grado");
        String nivel=request.getParameter("nivel");
        String turno=request.getParameter("turno");
       
        request.setAttribute("grado", grado);
        request.setAttribute("nivel", nivel);
        request.setAttribute("turno", turno);
         
       getServletContext().getRequestDispatcher(PATH_FORM_REPORT).forward(request, response);
          
        
    }

//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException, Exception {        
//        
//       int id = Integer.parseInt(request.getParameter("id"));
//        
//       AlumnoBO alumnoBO= new AlumnoBO();        
//       Alumno alumno=alumnoBO.buscarPorId(id);
//       
//       if(alumno==null){
//        request.setAttribute("mensaje", "Alumno no encontrado");       
//        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
//      
//       }else{
//        request.setAttribute("alumno", alumno);       
//        getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
//       }             
//
//    }
    

    private void update(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {      
       
        
           String[] matriculaId;
           String[] notas;

            matriculaId= request.getParameterValues("matriculaId");
            notas= request.getParameterValues("notas");
            
            int  cursoId=Integer.valueOf(request.getParameter("cursoId"));            
            int  bimestre=Integer.valueOf(request.getParameter("bimestre"));
            
            
            
       
        
        
//        Map<String,String>errores= alumno.getErrores();
//                   
//        if(errores.isEmpty()){                
//           AlumnoBO alumnoBO= new AlumnoBO(); 
//           alumnoBO.actualizar(alumno);
//           request.setAttribute("mensaje", "El registro fué actualizado con éxito"); 
//           getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
//        }else{
//            request.setAttribute("alumno", alumno);
//            request.setAttribute("errores", errores);            
//            
//            getServletContext().getRequestDispatcher(PATH_FORM_EDIT).forward(request, response);
//        }        
        
        
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));        
        
        AlumnoBO alumnoBO= new AlumnoBO(); 
        alumnoBO.eliminar(id);
        request.setAttribute("mensaje", "El registro fué eliminado con éxito"); 
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);        

    }
    
    

    
    
}
