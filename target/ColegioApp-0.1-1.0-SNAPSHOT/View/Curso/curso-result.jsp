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
                <h1>${mensaje}</h1>
                <a href="${pageContext.request.contextPath}/Curso?action=index">Regresar al inicio</a>
            </div>
            
            <div class="row">
                <form action="action"></form>
                
            </div>  
        
         </div>   
            
         </div>
            
         </div>
        
         <%@ include file="/View/Container/footer.jsp" %>
    </body>
</html>
