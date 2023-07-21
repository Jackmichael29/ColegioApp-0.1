<%-- 
    Document   : usuario-form-new
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
                <h1>Editar Datos del Usuario</h1>
                <a href="${pageContext.request.contextPath}/Usuario?action=index" class="btn btn-secondary">Regresar al inicio</a>
            </div>       
            
            <div class="row">        
      
        
        <form action="${pageContext.request.contextPath}/Usuario?action=update" method="post">     
      
            <div class="mb-3">
                <label for="dni" class="form-label">DNI</label>
                <input type="text" name="dni" value="${usuario.dni}" autocomplete="off" class="form-control"/>            
                <c:if test="${errores != null && not empty errores.dni}">
                    <div style="color:red;">${errores.dni}</div>
                </c:if>
            </div>
                
            <div class="mb-3">
                <label for="apellidoPaterno" class="form-label">Apellido paterno</label>
                <input type="text" name="apellidoPaterno" value="${usuario.apellido_paterno}" autocomplete="off" class="form-control"/> 
                <c:if test="${errores != null && not empty errores.apellido_paterno}">
                    <div style="color:red;">${errores.apellido_paterno}</div>
                </c:if>            
            </div>
            
            <div class="mb-3">
                <label for="apellidoMaterno" class="form-label">Apellido materno</label>
                <input type="text" name="apellidoMaterno" value="${usuario.apellido_materno}" autocomplete="off" class="form-control"/>            
                <c:if test="${errores != null && not empty errores.apellido_materno}">
                    <div style="color:red;">${errores.apellido_materno}</div>
                </c:if>               
            </div>
            
            <div class="mb-3">
                <label for="nombres" class="form-label">Nombres</label>
                <input type="text" name="nombres" value="${usuario.nombres}" autocomplete="off" class="form-control"/>            
                <c:if test="${errores != null && not empty errores.nombres}">
                    <div style="color:red;">${errores.nombres}</div>
                </c:if>             
            </div>
            
            <div class="mb-3">
                    <label for="rol" class="form-label">Rol</label>
                    <input type="text" name="rol" value="${usuario!=null? usuario.rol:""}" autocomplete="off" class="form-control"/>            
                    <c:if test="${errores != null && not empty errores.rol}">
                    <div style="color:red;">${errores.rol}</div>
                    </c:if>             
            </div>
            
            <div class="mb-3">
                <input type="submit" value="Editar" class="btn btn-primary">
            </div>
                
            <input type="hidden" name="id" value="${usuario.usuario_id}">
            
            
        </form>
            
            
         </div>   
        
        </div>   
            
         </div>
            
         </div>
            <%@ include file="/View/Container/footer.jsp" %>
    </body>
</html>
