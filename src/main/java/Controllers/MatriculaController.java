/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import BusinessLayer.AlumnoBO;
import BusinessLayer.MatriculaBO;
import JavaBean.Alumno;
import JavaBean.Matricula;
import com.google.gson.Gson;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author walter
 */
@WebServlet("/Matricula")
public class MatriculaController extends HttpServlet {
 

    static final String PATH_FORM_NEW="/View/Matricula/matricula-form-new.jsp";
    static final String PATH_FORM_EDIT="/View/Alumno/alumno-form-edit.jsp";
    static final String PATH_RESULT="/View/Matricula/matricula-result.jsp";
    static final String PATH_INDEX="/View/Alumno/alumno-index.jsp"; 
    static final String PATH_SEARCH_ALU_BY_APENOM="/View/Matricula/matricula-buscar-alumno-apellidos-nombres.jsp";
    static final String PATH_SEARCH_ALU_BY_ID="/View/Matricula/matricula-buscar-alumno-id.jsp";
 
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
                case "searchAlumByApenom":
                    searchAlumByApenom(request, response);
                    break;
                case "new":                    
                    showNewForm(request, response);
                    break;
                case "insert":
                    insert(request, response);
                    break;
                case "searchAlumById":
                    searchAlumById(request, response);
                    break;
                //case "update":
                    //update(request, response);
                    //break;
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

    
    
    private void searchAlumByApenom(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        String  apeNom=request.getParameter("alumno");        
        
        AlumnoBO alumnoBO= new AlumnoBO(); 
        ArrayList<Alumno> alumnos=alumnoBO.buscarPorAlumno(apeNom);
        request.setAttribute("alumnos", alumnos);
        
        getServletContext().getRequestDispatcher(PATH_SEARCH_ALU_BY_APENOM).forward(request, response);
        

    }
    
    private void searchAlumById(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int  id=Integer.valueOf(request.getParameter("alumnoId"));
        
        AlumnoBO alumnoBO= new AlumnoBO(); 
        Alumno alumno=alumnoBO.buscarPorId(id);
        //request.setAttribute("alumno", alumno);
        
        
    Map<String, String> options = new LinkedHashMap<String, String>();
    
        //---nota: tener cuidsado con los objetos con campos date, localdate. Para ello hay que serializar y desserializar
    
        options.put("alumnoId",String.valueOf(alumno.getAlumno_id()));
        options.put("apellidosNombres", alumno.getApellidosNombres());
   
        
        Gson gson = new Gson();
        
        String alumnoJsonString = gson.toJson(options);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(alumnoJsonString);
        
        

        
        
       // out.print(alumnoJsonString);
       //out.flush();
        
        //request.setAttribute("alumno", alumno);  
       // getServletContext().getRequestDispatcher(PATH_SEARCH_ALU_BY_ID).forward(request, response);
        

    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {       
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(PATH_FORM_NEW);
        dispatcher.forward(request, response);
    }
    
    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, Exception {

        Alumno alumno = new Alumno();
        Matricula matricula = new Matricula();

        alumno.setAlumno_id(Integer.valueOf(request.getParameter("alumnoId")));

        matricula.setGrado(request.getParameter("grado").charAt(0));
        matricula.setNivel(request.getParameter("nivel").charAt(0));
        matricula.setTurno(request.getParameter("turno").charAt(0));

        try {
            matricula.setFecha(LocalDate.parse(request.getParameter("fecha"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } catch (DateTimeParseException e) {
            matricula.setFecha(null);
        }

        Map<String, String> errores = matricula.getErrores();

        if (errores.isEmpty()) {
            MatriculaBO matriculaBO = new MatriculaBO();
            matriculaBO.insertarMatricula(matricula);
            request.setAttribute("mensaje", "El registro fué insertado con éxito");
            getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);
        } else {
            request.setAttribute("matricula", matricula);
            request.setAttribute("errores", errores);

            getServletContext().getRequestDispatcher(PATH_FORM_NEW).forward(request, response);

        }
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
    

//    private void update(HttpServletRequest request, HttpServletResponse response)
//    throws SQLException, IOException, Exception {      
//       
//        
//        Alumno alumno = new Alumno();
//        
//        alumno.setAlumnoId(Integer.parseInt(request.getParameter("id")));
//        alumno.setDni(request.getParameter("dni"));
//        alumno.setApellidoPaterno(request.getParameter("apellidoPaterno"));
//        alumno.setApellidoMaterno(request.getParameter("apellidoMaterno"));
//        alumno.setNombres(request.getParameter("nombres"));        
//        
//        try {
//            alumno.setFechaNacimiento(LocalDate.parse(request.getParameter("fechaNacimiento"),DateTimeFormatter.ofPattern("yyyy-MM-dd")) );
//        } catch (DateTimeParseException e) {
//            alumno.setFechaNacimiento(null);
//        }        
//        
//        alumno.setCorreoElectronico(request.getParameter("correoElectronico"));
//        
//        
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
//        
//        
//    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, Exception {
        
        int id = Integer.parseInt(request.getParameter("id"));        
        
        AlumnoBO alumnoBO= new AlumnoBO(); 
        alumnoBO.eliminar(id);
        request.setAttribute("mensaje", "El registro fué eliminado con éxito"); 
        getServletContext().getRequestDispatcher(PATH_RESULT).forward(request, response);        

    }
}
