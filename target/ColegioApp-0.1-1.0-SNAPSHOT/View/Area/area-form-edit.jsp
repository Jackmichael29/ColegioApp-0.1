<%-- 
    Document   : area-form-new
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
                <h1>Editar Datos de Area</h1>
                <a href="${pageContext.request.contextPath}/Area?action=index">Regresar al inicio</a>
            </div>       
            
            <div class="row">        
      
        
        <form action="${pageContext.request.contextPath}/Area?action=update" method="post">     
                
            <div class="mb-3">
                <label for="areaNombre" class="form-label">Nombre de área</label>
                <input type="text" name="areaNombre" value="${area.area_nombre}" autocomplete="off" class="form-control"/> 
                <c:if test="${errores != null && not empty errores.area_nombre}">
                    <div style="color:red;">${errores.area_nombre}</div>
                </c:if>            
            </div>
            
            <div class="mb-3">
                <input type="submit" value="Editar" class="btn btn-primary">
            </div>
                
            <input type="hidden" name="id" value="${area.area_id}">
            
            
        </form>
            
            
         </div>   
        
        </div>   
            
         </div>
            
         </div>
            <%@ include file="/View/Container/footer.jsp" %>
    </body>
</html>
