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
                <h1>Notas de los alumnos</h1>
            </div>
            <form action="${pageContext.request.contextPath}/Nota?action=index" method="post" >
                <div>
                    <div class="alinear">
                        <label class="textoLabel" for="cursoNombre" class="form-label">Curso</label>
                        <input class="textoBuscar" type="text" name="nombreCurso" id="nombreCurso" value="" autocomplete="off" class="form-control"/>
                        <button class="button1 btn2" type="submit" value="Buscar">
                            <svg viewBox="0 0 16 16" class="bi bi-arrow-repeat" fill="currentColor" height="16" width="16" xmlns="http://www.w3.org/2000/svg">
                            <path d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"></path>
                            <path d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z" fill-rule="evenodd"></path>
                            </svg>
                            Buscar
                        </button>
                    </div>
                    <div class="mb-3">
                        <label for="nivel">Elige un nivel:</label>
                        <select name="nivel" id="nivel">
                            <option value="">--seleccionar--</option>
                            <option value="p">p</option>
                            <option value="s">s</option>       
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
                </div>
            </form>
            <div class="row">

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Alumno</th>
                            <th scope="col">1er Bimestre</th>
                            <th scope="col">2do Bimestre</th>
                            <th scope="col">3er Bimestre</th>
                            <th scope="col">4to Bimestre</th>
                            <th scope="col">Comportamiento</th>
                            <th scope="col">Promedio</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${notas}" var="n">
                        <tr>
                            <td>${n.alumno.apellidosNombres} </td>
                            <td>${n.nota.nota1} </td>
                            <td>${n.nota.nota2} </td>
                            <td>${n.nota.nota3} </td>
                            <td>${n.nota.nota4} </td>
                            <td>${n.nota.nota5} </td>
                            <td>${n.promedio} </td> 
                            <td><a href="${pageContext.request.contextPath}/Nota?action=editNota&notaId=${n.historial_id}" class="btn btn-secondary" role="button">Modificar</a></td>
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