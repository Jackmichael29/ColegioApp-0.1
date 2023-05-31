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
                <h1>Cambiar Clave del Usuario</h1>
                <a href="${pageContext.request.contextPath}/Usuario?action=index" class="btn btn-secondary">Regresar al inicio</a>
            </div>       
            
            <div class="row">        
      
        
        <form action="${pageContext.request.contextPath}/Usuario?action=cambiarClave" method="post">     
      
            <div class="mb-3">
                    <label for="rol" class="form-label">Clave</label>
                    <input type="password" name="clave" value="${usuario!=null? usuario.clave:""}" autocomplete="off" class="form-control"/>            
                    <c:if test="${errores != null && not empty (errores.clave || errores.claveLen)}">
                    <div style="color:red;">${errores.clave}</div>
                    <div style="color:red;">${errores.claveLen}</div>
                    </c:if>             
            </div>
            
            <div class="mb-3">
                <input type="submit" value="Cambiar" class="btn btn-primary">
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
