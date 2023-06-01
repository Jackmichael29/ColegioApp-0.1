<%-- 
    Document   : alumno-form-new
    Created on : May 18, 2023, 1:42:44 PM
    Author     : xbest
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1>Datos de Usuario Nuevo</h1>
                <a href="${pageContext.request.contextPath}/Usuario?action=index">Regresar al inicio</a>
            </div>
            
            
            <div class="row">        
                
          
            <form action="${pageContext.request.contextPath}/Usuario?action=insert" method="post">       
            
                <div class="mb-3">
                    <label for="dni" class="form-label">DNI</label>
                    <input type="text" name="dni" value="${usuario!=null? usuario.dni:""}" autocomplete="off" class="form-control"/>            
                    <c:if test="${errores != null && not empty errores.dni}">
                    <div style="color:red;">${errores.dni}</div>
                    </c:if>                    
                </div>            

                <div class="mb-3">    
                    <label for="apellidoPaterno" class="form-label">Apellido paterno</label>
                    <input type="text" name="apellidoPaterno" value="${usuario!=null? usuario.apellido_paterno:""}" autocomplete="off" class="form-control"/>
                    <c:if test="${errores != null && not empty errores.apellido_paterno}">
                    <div style="color:red;">${errores.apellido_paterno}</div>
                    </c:if>            
                </div>  

                <div class="mb-3">
                    <label for="apellidoMaterno" class="form-label">Apellido materno</label>
                    <input type="text" name="apellidoMaterno" value="${usuario!=null? usuario.apellido_materno:""}" autocomplete="off" class="form-control"/>            
                    <c:if test="${errores != null && not empty errores.apellido_materno}">
                    <div style="color:red;">${errores.apellido_materno}</div>
                    </c:if>   
                </div>

                <div class="mb-3">
                    <label for="nombres" class="form-label">Nombres</label>
                    <input type="text" name="nombres" value="${usuario!=null? usuario.nombres:""}" autocomplete="off" class="form-control"/>            
                    <c:if test="${errores != null && not empty errores.nombres}">
                    <div style="color:red;">${errores.nombres}</div>
                    </c:if>             
                </div>
                    
                <div class="mb-3">
                    <label for="rol" class="form-label">Clave</label>
                    <input type="password" name="clave" value="${usuario!=null? usuario.clave:""}" autocomplete="off" class="form-control"/>            
                    <c:if test="${errores != null && not empty (errores.clave || errores.claveLen)}">
                    <div style="color:red;">${errores.clave}</div>
                    <div style="color:red;">${errores.claveLen}</div>
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
                    <input type="submit" value="Crear" class="btn btn-primary">            
                </div>
                
            </form>
                
                
        </div>
            
        </div>

    </div>
                
                
    </div>
                
                
     <%@ include file="/View/Container/footer.jsp" %>
    </body>
</html>
