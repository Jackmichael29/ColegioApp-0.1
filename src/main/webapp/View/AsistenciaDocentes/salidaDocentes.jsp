<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  
import= "JavaBean.Alumno, java.util.ArrayList"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>   
    
 <%@ include file="/View/Container/head.jsp" %>  


<body>
    
   <div class="row grow w-100">  
            
   <%@ include file="/View/Container/header.jsp" %>     
   <%@ include file="/View/Container/nav.jsp" %>
    
    <div class="main col-10 h-100 py-3">            

        <div class="container"> 

            <div class="row" >
                <h1>Asistencia de los Docentes</h1>
                <h3>Fecha: ${fecha}</h3>
            </div>
            <form action="${pageContext.request.contextPath}/AsistenciaDocentesSalida?action=insert" method="post" >
                <div>
                    <div class="alinear">
                        <div>
                            <label class="textoLabel" for="usuario" class="form-label">Usuario</label>
                            <input class="textoBuscar" type="text" name="usuario" id="usuario" value="" autocomplete="off" class="form-control"/>
                            <c:if test="${errores != null && not empty errores.usuario}">
                                <div style="color:red;">${errores.usuario}</div>
                            </c:if> 
                        </div>

                        <div>
                            <label class="textoLabel" for="contrasena" class="form-label">Contrasena</label>
                            <input class="textoBuscar" type="password" name="contrasena" id="contrasena" value="" autocomplete="off" class="form-control"/>
                            <c:if test="${errores != null && not empty errores.contrasena}">
                                <div style="color:red;">${errores.contrasena}</div>
                            </c:if> 
                        </div>
                        
                        <button class="button1 btn2" type="submit" value="Salida">
                            <svg viewBox="0 0 16 16" class="bi bi-arrow-repeat" fill="currentColor" height="16" width="16" xmlns="http://www.w3.org/2000/svg">
                            <path d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"></path>
                            <path d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z" fill-rule="evenodd"></path>
                            </svg>
                            Salida
                        </button>
                    </div>
                </div>
            </form>   
                
            <div class="row">

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Docente</th>
                            <th scope="col">Hora Ingreso</th>
                            <th scope="col">Hora Salida</th>
                            <!--<th scope="col">Acciones</th>-->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${docentes}" var="a">
                        <tr>
                            <td> ${a.docente.apellidosNombres} </td>
                            <td> ${a.hora_ingreso} </td>
                            <td> ${a.hora_salida} </td>
                            <!--<td><a href="${pageContext.request.contextPath}/AsistenciaAlumno?action=editAsistencia&asistenciaId=${asis.asistencia_alumno_id}" class="btn btn-secondary" role="button">Modificar</a></td>-->
                        </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>     
            
  <%@ include file="/View/Container/footer.jsp" %>
</body>



</html>