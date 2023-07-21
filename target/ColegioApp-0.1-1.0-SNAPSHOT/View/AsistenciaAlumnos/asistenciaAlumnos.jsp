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
                <h1>Asistencia de los alumnos</h1>
                <h3>Fecha: ${fecha}</h3>
            </div>
            <form action="${pageContext.request.contextPath}/AsistenciaAlumnos?action=index" method="post" >
                <div>
                    <div class="alinear">
<!--                        <label class="textoLabel" for="cursoNombre" class="form-label">Curso</label>
                        <input class="textoBuscar" type="text" name="nombreCurso" id="nombreCurso" value="" autocomplete="off" class="form-control"/>-->
                        <div class="mb-3">
                            <label for="nivel">Elige un nivel:</label>
                            <select name="nivel" id="nivel">
                                <option value="">--seleccionar--</option>
                                <option value="I">I</option>
                                <option value="P">P</option>
                                <option value="S">S</option>       
                            </select>
                        </div>
                        <div class="mb-3">   
                            <label for="grado">Elige un grado:</label>
                            <select name="grado" id="grado">
                                <option value="">--seleccionar--</option>
                                <option value="1">1 grado</option>
                                <option value="2">2 grado</option>
                                <option value="3">3 grado</option>
                                <option value="4">4 grado</option>
                                <option value="5">5 grado</option>
                                <option value="6">6 grado</option>
                            </select>
                        </div>
                        <button class="button1 btn2" type="submit" value="Buscar">
                            <svg viewBox="0 0 16 16" class="bi bi-arrow-repeat" fill="currentColor" height="16" width="16" xmlns="http://www.w3.org/2000/svg">
                            <path d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"></path>
                            <path d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z" fill-rule="evenodd"></path>
                            </svg>
                            Buscar
                        </button>
                    </div>
                </div>
            </form>
            <div class="row">

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Alumno</th>
                            <th scope="col">Asistencia</th>
                            <th scope="col">Tardanza</th>
                            <!--<th scope="col">Acciones</th>-->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${hnotas}" var="a">
                        <tr>
                            <td>${a.apellidosNombres} </td>
                            <td> <input id="asistencia" type="checkbox" value="asistio" checked> </td>
                            <td> <input id="tardanza" type="checkbox" value="tarde"> </td>
                            <!--<td><a href="${pageContext.request.contextPath}/AsistenciaAlumno?action=editAsistencia&asistenciaId=${asis.asistencia_alumno_id}" class="btn btn-secondary" role="button">Modificar</a></td>-->
                        </c:forEach>
                        </tr>
                    </tbody>
                </table>
                <button class="button1 btn2" type="submit" value="Buscar">
                    <svg viewBox="0 0 16 16" class="bi bi-arrow-repeat" fill="currentColor" height="16" width="16" xmlns="http://www.w3.org/2000/svg">
                    <path d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"></path>
                    <path d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z" fill-rule="evenodd"></path>
                    </svg>
                    Registrar
                </button>
            </div>
        </div>
    </div>     
            
  <%@ include file="/View/Container/footer.jsp" %>
</body>



</html>