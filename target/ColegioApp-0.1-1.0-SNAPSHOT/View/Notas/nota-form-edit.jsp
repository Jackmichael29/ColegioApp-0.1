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
               <h2>Notas del alumno: ${hnotita.alumno.apellidosNombres}</h2>
               <h3>Curso: ${hnotita.curso.nombre}</h3>
               <h3>Grado: ${hnotita.curso.grado}</h3>
               <h3>Nivel: ${hnotita.curso.nivel}</h3>
            </div>
            
            <div class="row">
                
                <form action="${pageContext.request.contextPath}/Nota?action=update" method="post">
                    <div>
                        1er Bimestre
                        <input type="text" name="nota1" id="nota1" value="${notas.nota1}" autocomplete="off" class="form-control"/> 
                    </div>
                    <div>
                        2do Bimestre
                        <input type="text" name="nota2" id="nota2" value="${notas.nota2}" autocomplete="off" class="form-control"/> 
                    </div>
                    <div>
                        3er Bimestre
                        <input type="text" name="nota3" id="nota3" value="${notas.nota3}" autocomplete="off" class="form-control"/> 
                    </div>
                    <div>
                        4to Bimestre
                        <input type="text" name="nota4" id="nota4" value="${notas.nota4}" autocomplete="off" class="form-control"/> 
                    </div>
                    <div>
                        Comportamiento
                        <input type="text" name="nota5" id="nota5" value="${notas.nota5}" autocomplete="off" class="form-control"/> 
                    </div>

                    <div class="mb-3">                                

                        <c:if test="${errores != null && not empty errores.dni}">
                            <div style="color:red;">${errores.dni}</div>
                        </c:if>
                    </div>
                    
                    <div class="mb-3">
                            <input type="submit" value="Editar" class="btn btn-primary">
                    </div>
            
                </form>      
                    
            </div>
                    
                    
                    
            </div>
            </div>     
            
  <%@ include file="/View/Container/footer.jsp" %>
</body>



</html>