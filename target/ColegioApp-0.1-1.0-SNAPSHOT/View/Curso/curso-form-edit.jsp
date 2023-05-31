<%-- 
    Document   : curso-form-new
    Created on : May 18, 2023, 1:42:44 PM
    Author     : xbest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
       
       
            <div class="row">
                <h1>Editar Datos de Curso</h1>
                <a href="${pageContext.request.contextPath}/Curso?action=index">Regresar al inicio</a>
            </div>       
            
            <div class="row">        
      
        
        <form action="${pageContext.request.contextPath}/Curso?action=update" method="post">     
      
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" name="nombre" value="${curso.nombre}" autocomplete="off" class="form-control"/>            
                <c:if test="${errores != null && not empty errores.nombre}">
                    <div style="color:red;">${errores.nombre}</div>
                </c:if>
            </div>
                
            <div class="mb-3">
                <label for="grado" class="form-label">Grado</label>
                <input type="text" name="grado" value="${curso.grado}" autocomplete="off" class="form-control"/> 
                <c:if test="${errores != null && not empty errores.grado}">
                    <div style="color:red;">${errores.grado}</div>
                </c:if>            
            </div>
            
            <div class="mb-3">
                <label for="nivel" class="form-label">Nivel</label>
                <input type="text" name="nivel" value="${curso.nivel}" autocomplete="off" class="form-control"/>            
                <c:if test="${errores != null && not empty errores.nivel}">
                    <div style="color:red;">${errores.nivel}</div>
                </c:if>               
            </div>
            
            <div class="mb-3">
                <label for="areaId" class="form-label">Area ID</label>
                <input type="text" name="areaId" value="${curso.area_id}" autocomplete="off" class="form-control"/>            
                <c:if test="${errores != null && not empty errores.area_id}">
                    <div style="color:red;">${errores.area_id}</div>
                </c:if>             
            </div>
            
            <div class="mb-3">
                <input type="submit" value="Editar" class="btn btn-primary">
            </div>
                
            <input type="hidden" name="id" value="${curso.curso_id}">
            
            
        </form>
            
            
         </div>   
        
        </div>   
            
         </div>
            
         </div>
            <%@ include file="/View/Container/footer.jsp" %>
    </body>
</html>
